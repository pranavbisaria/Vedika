package com.Vedika.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
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
}
