package com.Vedika.Controller;
import com.Vedika.Service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequiredArgsConstructor
public class StatusController {
    private final AdminService adminService;
    @RequestMapping("/")
    public String landingPage(HttpServletRequest httpRequest) {
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "index.html";
    }
//    private final MeterRegistry meterRegistry;
//    public final ConcurrentHashMap<String, Long> userCounts;

//    public StatusController(MeterRegistry meterRegistry) {
//        this.meterRegistry = meterRegistry;
//        this.userCounts = new ConcurrentHashMap<>();
//        meterRegistry.gauge("unique.visitors.last.24h", userCounts, ConcurrentHashMap::size);
//    }

//    @RequestMapping("/")
//    public String landingPage(HttpServletRequest request) {
//        String ip = request.getRemoteAddr();;
//        String key = ip + "-" + System.currentTimeMillis() / 1000 / 60 / 5;
//
//        userCounts.put(key, System.currentTimeMillis());
//
//        Counter counter = meterRegistry.counter("unique.visitors");
//        counter.increment();
//        return "/index.html";
//    }
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
    @RequestMapping("/services")
    public String service(HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return "/services.html";
    }
    @GetMapping("/admin")
    public String admin() {
        return "/admin/adminpanel.html";
    }
}
