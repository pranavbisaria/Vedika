package com.Vedika.Controller;
import com.Vedika.Service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StatusController {
    private final AdminService adminService;
    @GetMapping("/")
    public String landingPage(HttpServletRequest httpRequest) {
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "index";
    }
    @GetMapping("/home")
    public String home(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "index";
    }
    @GetMapping("/products")
    public String products(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "products";

    }
    @GetMapping("/contactUs")
    public String contact(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "contact";
    }
    @GetMapping("/services")
    public String service(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "services";
    }
    @GetMapping("/viewproduct")
    public String viewProductPage(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "productId";
    }
}
