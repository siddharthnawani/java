package threads.completableFuture.exceptionHandling;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int x = 10;
            return x / 0;
        }).exceptionally(error -> {
            System.out.println("Error occurred!: " + error.getMessage());
            return 0;
        });
        System.out.println(future.join());

        //We can modify this example also by chaining a callback method.

        CompletableFuture.supplyAsync(() -> {
            int x = 10;
            return x / 0;
        }).exceptionally(error -> {
            System.out.println("Error occurred!: " + error.getMessage());
            return 0;
        }).thenAcceptAsync(x -> {
            System.out.println(x + 10);
        });
    }
}

// output:
// Error occurred!: java.lang.ArithmeticException: / by zero
// 0