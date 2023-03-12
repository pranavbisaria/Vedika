package com.Vedika.Controller;

import com.Vedika.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @GetMapping("")
    public String admin() {
        return "adminpanel";
    }

    @GetMapping("/product-list")
    public String productList(){
        return "product-index-page";
    }

    @GetMapping("/visitorResponse")
    public String visitorResponse(){
        return "formsubmission";
    }

    @GetMapping("/addProduct")
    public String addProduct(){
        return "add-product";
    }
    @GetMapping("/visitor-count")
    public ResponseEntity<?> getVisitorCount() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getVisitorCount());
    }
}
