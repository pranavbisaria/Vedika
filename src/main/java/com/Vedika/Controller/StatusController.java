package com.Vedika.Controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class StatusController {
    private final MeterRegistry meterRegistry;
    public final ConcurrentHashMap<String, Long> userCounts;

    public StatusController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.userCounts = new ConcurrentHashMap<>();
        meterRegistry.gauge("unique.visitors.last.24h", userCounts, ConcurrentHashMap::size);
    }

    @RequestMapping("/")
    public String landingPage(HttpServletRequest request) {
        String ip = request.getRemoteAddr();;
        String key = ip + "-" + System.currentTimeMillis() / 1000 / 60 / 5;

        userCounts.put(key, System.currentTimeMillis());

        Counter counter = meterRegistry.counter("unique.visitors");
        counter.increment();
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
    @RequestMapping("/services")
    public String service(){
        return "/services.html";
    }
    @GetMapping("/admin")
    public String admin() {
        return "/admin/adminpanel.html";
    }
}
