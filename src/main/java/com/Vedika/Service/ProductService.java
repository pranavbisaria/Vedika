package com.Vedika.Service;

import com.Vedika.Payload.AddProduct;
import com.Vedika.Payload.GetProduct;
import com.Vedika.Payload.PageResponse;
import com.Vedika.Payload.PageableDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ResponseEntity<?> addProduct(GetProduct productDto, MultipartFile[] file);

    ResponseEntity<?> addNewProductData(AddProduct productDto);

    ResponseEntity<?> addNewProductImages(Long Id, MultipartFile[] images);

    PageResponse getAll(PageableDto pageable);
    ResponseEntity<?> productById(Long Id);

    ResponseEntity<?> deleteProductById(Long Id);
}
