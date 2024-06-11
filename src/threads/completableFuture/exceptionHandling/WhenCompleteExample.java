package threads.completableFuture.exceptionHandling;

import java.util.concurrent.CompletableFuture;

public class WhenCompleteExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            int x = 10;
            return x / 2;
        }).whenComplete((result, error) -> {
            if (error != null) {
                System.out.println("Error occurred!: " + error.getMessage());
            } else {
                System.out.println(result);
            }
        });

        /****
         *
         * If we chain a callback method after this, it won’t behave like exceptionally and handle methods. We cannot return a result a value inside this whenComplete method. That’s the reason.
         *
         *
         * ***/
    }
}

// output:
// Error occurred!: java.lang.ArithmeticException: / by zero