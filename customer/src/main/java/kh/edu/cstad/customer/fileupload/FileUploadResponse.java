package kh.edu.cstad.customer.fileupload;

public record FileUploadResponse(
        String name,
        String type,
        String uri,
        Long size
) {
}
