package com.Vedika.Controller;

import com.Vedika.Payload.GetProduct;
import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.ProductDto;
import com.Vedika.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<?> addNewProduct(@RequestPart("images") MultipartFile[] images,@Valid @RequestPart GetProduct productDto){
        return this.productService.addProduct(productDto, images);
    }
    @GetMapping("/allProducts")
    public ResponseEntity<?> getAllProducts(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = "des", required = false) String sortDir
    ){
        return new ResponseEntity<>(this.productService.getAll(new PageableDto(pageNumber, pageSize, sortBy, sortDir)), OK);
    }
}
