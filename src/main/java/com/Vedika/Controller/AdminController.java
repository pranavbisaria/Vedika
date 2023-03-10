package com.Vedika.Controller;

import com.Vedika.Model.CountVisitor;
import com.Vedika.Service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/visitor-count")
    public int getVisitorCount() {
        return adminService.getVisitorCount();
    }
    


}
