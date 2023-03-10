package com.Vedika.Controller;
import com.Vedika.Service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequiredArgsConstructor
public class StatusController {
    private final AdminService adminService;
    @RequestMapping("/")
    public String landingPage(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "/index.html";
    }
    @RequestMapping("/home")
    public String home(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "/index.html";
    }
    @RequestMapping("/products")
    public String products(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "/products.html";
    }
    @RequestMapping("/contactUs")
    public String contact(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "/contact.html";
    }
}
