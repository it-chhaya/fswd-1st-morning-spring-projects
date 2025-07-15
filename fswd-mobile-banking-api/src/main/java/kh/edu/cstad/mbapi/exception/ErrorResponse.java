package kh.edu.cstad.mbapi.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse<T>(
        String message,
        Integer status,
        LocalDateTime timestamp,
        T details
) {
}
