package threads.completableFuture.exceptionHandling;

import java.util.concurrent.CompletableFuture;

public class HandleExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int x = 10;
            return x / 0;
        }).handle((result, error) -> {
            if (error != null) {
                System.out.println("Error occurred!: " + error.getMessage());
                return 0;
            }
            return result;
        });
        System.out.println(future.join());;

        //We can modify this example by chaining a callback method.

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int x = 10;
            return x / 2;
        }).handle((result, error) -> {
            if (error != null) {
                System.out.println("Error occurred!: " + error.getMessage());
                return 5;
            }
            return result;
        }).thenApplyAsync(x -> x + 20);
        System.out.println(future2.join());
    }
}

// output:
// Error occurred!: java.lang.ArithmeticException: / by zero
// 0