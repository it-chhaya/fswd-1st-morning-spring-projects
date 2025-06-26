package kh.edu.cstad.customer.client;

import java.time.LocalDateTime;

/**
 * {
 * "id": 1,
 * "name": "Clothes",
 * "slug": "clothes",
 * "image": "https://i.imgur.com/QkIa5tT.jpeg",
 * "creationAt": "2025-06-22T15:19:21.000Z",
 * "updatedAt": "2025-06-22T15:19:21.000Z"
 * }
 */
public record Category(
        Integer id,
        String name,
        String slug,
        String image,
        LocalDateTime creationAt,
        LocalDateTime updatedAt
) {
}
