package com.Vedika.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {
    @GetMapping("/")
    public String landingPage() {
        return "index";
    }
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @GetMapping("/products")
    public String products(){
        return "products";
    }
    @GetMapping("/contactUs")
    public String contact(){
        return "contact";
    }
    @GetMapping("/services")
    public String service(){
        return "services";
    }
//    @GetMapping("/error")
}
