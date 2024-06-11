package threads.completableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenApplyAsyncExample {
    public static void main(String[] args) {

        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello from Task 1::supplyAsync::" + Thread.currentThread().getName());
            return "Hey";
        });
        System.out.println("Hello from Main::" + Thread.currentThread().getName());
        CompletableFuture<String> stringCompletableFuture = taskCompletableFuture.thenApplyAsync(data -> {
            System.out.println("Hello from Task 1::thenApplyAsync::" + Thread.currentThread().getName());
            return data + " Developers!";
        });
        String result = stringCompletableFuture.join();
        System.out.println(result);
    }
}

// output:
// Hello from Main::main
// Hello from Task 1::supplyAsync::ForkJoinPool.commonPool-worker-1
// Hello from Task 1::thenApplyAsync::ForkJoinPool.commonPool-worker-1
// Hey Developers!