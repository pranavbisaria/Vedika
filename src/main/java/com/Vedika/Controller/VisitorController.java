package com.Vedika.Controller;

import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.VisitorDto;
import com.Vedika.Service.AdminService;
import com.Vedika.Service.VisitorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visitor")
public class VisitorController {
    private final VisitorService visitorService;
    private final AdminService adminService;
    @PostMapping("/contactUs/{smartTvId}")
    public ResponseEntity<?> newVisitor(@RequestBody VisitorDto visitorDto, @PathVariable("smartTvId") Long smartTvId, HttpServletRequest httpRequest){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return this.visitorService.newVisitors(visitorDto, smartTvId);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllVisitors(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = "productId", required = false) String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = "des", required = false) String sortDir,
                                            HttpServletRequest httpRequest
    ){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return  new ResponseEntity<>(this.visitorService.getAll(new PageableDto(pageNumber, pageSize, sortBy, sortDir)), OK);
    }
}
