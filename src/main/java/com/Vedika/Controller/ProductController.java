package com.Vedika.Controller;

import com.Vedika.Payload.AddProduct;
import com.Vedika.Payload.GetProduct;
import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.ProductDto;
import com.Vedika.Service.AdminService;
import com.Vedika.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final AdminService adminService;
    private final ObjectMapper objectMapper;
    @PostMapping("/add")
    public ResponseEntity<?> addNewProduct(@RequestParam("images") MultipartFile[] images, @Valid @RequestParam("productDto") String productDto){
        GetProduct getProduct = null;
        try {
            getProduct = objectMapper.readValue(productDto, GetProduct.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(BAD_REQUEST).body("Invalid Request");
        }
        return this.productService.addProduct(getProduct, images);
    }
    @PostMapping("/addProductData")
    public ResponseEntity<?> addNewProductData(@Valid @RequestBody AddProduct productDto){
        return this.productService.addNewProductData(productDto);
    }
    @PatchMapping("/addProductData/{id}")
    public ResponseEntity<?> addProductImages(@RequestParam("images") MultipartFile[] images, @PathVariable("id") Long id){
        return this.productService.addNewProductImages(id, images);
    }
    @GetMapping("/allProducts")
    public ResponseEntity<?> getAllProducts(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = "des", required = false) String sortDir,
                                            HttpServletRequest httpRequest
    ){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return new ResponseEntity<>(this.productService.getAll(new PageableDto(pageNumber, pageSize, sortBy, sortDir)), OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        return this.productService.deleteProductById(id);
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id, HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return this.productService.productById(id);
    }
}
