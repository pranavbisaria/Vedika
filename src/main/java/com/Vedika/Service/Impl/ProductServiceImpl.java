package com.Vedika.Service.Impl;
import com.Vedika.Exceptions.ResourceNotFoundException;
import com.Vedika.Model.Images;
import com.Vedika.Model.Product;
import com.Vedika.Payload.*;
import com.Vedika.Repository.ProductRepo;
import com.Vedika.Service.FileServices;
import com.Vedika.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepo productRepo;
    private final FileServices fileServices;
    @Override
    public ResponseEntity<?> addProduct(GetProduct productDto, MultipartFile[] images){
        Product product = this.modelMapper.map(productDto, Product.class);
        if (FileValidation(images))
            return new ResponseEntity<>(new ApiResponse("File is not of image type(JPEG/ JPG or PNG)!!!", false), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        List<Images> productImages = new ArrayList<>(0);
        Arrays.stream(images).forEach(multipartFile -> {
            Images images1 = new Images();
            try {
                images1.setImageUrl(this.fileServices.uploadImage(multipartFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            productImages.add(images1);
        });
        product.setImageUrls(productImages);
        this.productRepo.save(product);
        return new ResponseEntity<>(new ApiResponse("Product has been successfully added", true), OK);
    }
    @Override
    public PageResponse getAll(PageableDto pageable){
        Integer pN = pageable.getPageNumber(), pS = pageable.getPageSize();
        Sort sort = null;
        if(pageable.getSortDir().equalsIgnoreCase("asc")){
            sort = Sort.by(pageable.getSortBy()).ascending();
        }
        else{
            sort = Sort.by(pageable.getSortBy()).descending();
        }
        Pageable p = PageRequest.of(pN, pS, sort);
        Page<Product> pageProduct = this.productRepo.findAll(p);
        List<Product> allProducts = pageProduct.getContent();
        List<ProductDto> productDTO = new ArrayList<>();
        for (Product product : allProducts) {
            ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
            productDto.setImageUrls(product.getImageUrls().get(0).getImageUrl());
            productDTO.add(productDto);
        }
        return new PageResponse(new ArrayList<>(productDTO), pageProduct.getNumber(), pageProduct.getSize(), pageProduct.getTotalPages(), pageProduct.getTotalElements(), pageProduct.isLast());
    }

    @Override
    public ResponseEntity<?> productById(Long Id) {
        Product product = this.productRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Product", "productID", Id));
        return new ResponseEntity<>(product, OK);
    }

    private boolean FileValidation(MultipartFile[] images) throws NullPointerException{
        for (MultipartFile image : images) {
            if (!image.getContentType().equals("image/png") && !image.getContentType().equals("image/jpg") && !image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/webp")) {
                return true;
            }
        }
        return false;
    }
}
