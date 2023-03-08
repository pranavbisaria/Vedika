package com.Vedika.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StatusController {
    @RequestMapping("/")
    public String landingPage(){
        return "/index.html";
    }
    @RequestMapping("/home")
    public String home(){
        return "/index.html";
    }
    @RequestMapping("/products")
    public String products(){
        return "/products.html";
    }
    @RequestMapping("/contactUs")
    public String contact(){
        return "/contact.html";
    }
}
