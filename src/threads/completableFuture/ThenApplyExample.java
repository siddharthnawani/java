package threads.completableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenApplyExample {
    public static void main(String[] args) {
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello from Task 1::supplyAsync::" + Thread.currentThread().getName());
            return "Hey";
        });
        System.out.println("Hello from Main::" + Thread.currentThread().getName());
        CompletableFuture<String> stringCompletableFuture = taskCompletableFuture.thenApply(data -> {
            System.out.println("Hello from Task 1::thenApply::" + Thread.currentThread().getName());
            return data + " Developers!";
        });
        String result = stringCompletableFuture.join();
        System.out.println(result);
    }
}

// output:
// Hello from Main::main
// Hello from Task 1::supplyAsync::ForkJoinPool.commonPool-worker-1
// Hello from Task 1::thenApply::main
// Hey Developers!