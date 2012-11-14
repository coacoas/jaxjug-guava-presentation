package com.jaxjug.guava;

import static com.jaxjug.guava.CollectionsExample.quote;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ConcurrencyExample {
	public static class OldWay {
		public String slowStringFunction1() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "hello, ";
		}
		
		public String slowStringFunction2() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "world!";
		}
		
		public String sequential() {
			String one = slowStringFunction1();
			String two = slowStringFunction2();
			
			return one + two;
		}
		
		public Optional<String> parallel() { 
			Optional<String> result = Optional.absent();
			try {
				ExecutorService exec = Executors.newCachedThreadPool();
				Future<String> one = exec.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						return slowStringFunction1();
					}});
				Future<String> two = exec.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						return slowStringFunction2();
					}});
				result = Optional.of(one.get() + two.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public Optional<String> listenableFutures() { 
			Optional<String> result = Optional.absent();
			try { 
				ListeningExecutorService exec = 
						MoreExecutors.listeningDecorator(
								Executors.newCachedThreadPool());
				ListenableFuture<String> future = 
						exec.submit(new Callable<String>() {
							@Override
							public String call() throws Exception {
								return slowStringFunction1();
							}});
				
				future.addListener(new Runnable() {
					@Override
					public void run() {
						System.out.println("Done");
					}
				}, exec);
				
				Futures.addCallback(future, new FutureCallback<String>() {

					@Override
					public void onSuccess(String result) {
						System.out.println("Done!");
					}

					@Override
					public void onFailure(Throwable t) {
						System.out.println("Failed. Logging and sounding siren");
					}});

				ListenableFuture<String> quoted = Futures.transform(future, quote);
				
				ListenableFuture<Integer> length = Futures.transform(future, new AsyncFunction<String, Integer>() {

					@Override
					public ListenableFuture<Integer> apply(String input)
							throws Exception {
						return Futures.immediateFuture(input.length());
					}
				});
				
				result = Optional.of(future.get());
			} catch (Exception e) { 
				e.printStackTrace();
			}
			return result;
		}
	}
}
