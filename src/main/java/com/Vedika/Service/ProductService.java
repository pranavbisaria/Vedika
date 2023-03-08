package com.Vedika.Service;

import com.Vedika.Payload.GetProduct;
import com.Vedika.Payload.PageResponse;
import com.Vedika.Payload.PageableDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ResponseEntity<?> addProduct(GetProduct productDto, MultipartFile[] file);
    PageResponse getAll(PageableDto pageable);
    ResponseEntity<?> productById(Long Id);
}
