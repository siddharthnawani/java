package threads.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ThenAcceptExample {
    public static void main(String[] args) {
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello from Task 1::supplyAsync::" + Thread.currentThread().getName());
            return "Hey";
        });
        System.out.println("Hello from Main::" + Thread.currentThread().getName());
        Consumer<String> consumer = (data) -> System.out.println(data + " Developers! Hello from Task 1::thenAcceptAsync::" + Thread.currentThread().getName());
        taskCompletableFuture.thenAcceptAsync(consumer).join();
    }
}

// output:
// Hello from Main::main
// Hello from Task 1::supplyAsync::ForkJoinPool.commonPool-worker-1
// Hey Developers! Hello from Task 1::thenAcceptAsync::ForkJoinPool.commonPool-worker-1