package kh.edu.cstad.customer.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final PlatziFakeStoreClient platziFakeStoreClient;

    @GetMapping
    public List<Category> getCategories() {
        try {
            List<Category> categories = platziFakeStoreClient.getCategories();
            categories.forEach(System.out::println);
            return categories;
        } catch (WebClientResponseException.NotFound exception) {
            return Collections.emptyList();
        }

    }

}
