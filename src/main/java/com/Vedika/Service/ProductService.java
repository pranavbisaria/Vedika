package com.Vedika.Service;

import com.Vedika.Payload.GetProduct;
import com.Vedika.Payload.PageResponse;
import com.Vedika.Payload.PageableDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ResponseEntity<?> addProduct(GetProduct productDto, MultipartFile[] file);

    ResponseEntity<?> addNewProductData(GetProduct productDto);

    ResponseEntity<?> addNewProductImages(Long Id, MultipartFile[] images);

    PageResponse getAll(PageableDto pageable);
    ResponseEntity<?> productById(Long Id);
}
