/*
package threads.completableFuture.demoRestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AggregatorService {
    @Autowired
    private AsyncRestTemplate restTemplate;

    public CompletableFuture<AggregatedResponse> getAggregatedResponse() {
        CompletableFuture<User[]> usersFuture = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject("http://localhost:8080/users", User[].class);
        });

        CompletableFuture<Product[]> productsFuture = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject("http://localhost:8080/products", Product[].class);
        });

        CompletableFuture<Order[]> ordersFuture = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject("http://localhost:8080/orders", Order[].class);
        });

        return CompletableFuture.allOf(usersFuture, productsFuture, ordersFuture)
            .thenApply(v -> new AggregatedResponse(usersFuture.join(), productsFuture.join(), ordersFuture.join()));
    }
}

@RestController
public class AggregatorController {
    @Autowired
    private AggregatorService aggregatorService;

    @GetMapping("/aggregate")
    public CompletableFuture<AggregatedResponse> getAggregatedResponse() {
        return aggregatorService.getAggregatedResponse();
    }
}

public class AggregatedResponse {
    private User[] users;
    private Product[] products;
    private Order[] orders;

    //getters and setters
}
*/
