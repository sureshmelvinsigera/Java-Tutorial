package com.gpcoder.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture13_WhenComplete {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> maturityFuture = 
				CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
			if (age < 0) {
				throw new IllegalArgumentException("Age can not be negative");
			}
			if (age > 18) {
				return "Adult";
			} else {
				return "Child";
			}
		}).whenComplete((res, ex) -> {
			if (ex != null) {
				System.out.println("Oops! We have an exception - " + ex.getMessage());
			}
		});
	}
}
