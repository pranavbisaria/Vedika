package com.Vedica.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StatusController {
    @RequestMapping("/")
    public String test(){
        return "/index.html";
    }
}
