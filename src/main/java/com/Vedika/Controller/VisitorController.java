package com.Vedika.Controller;

import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.RemarksDto;
import com.Vedika.Payload.VisitorDto;
import com.Vedika.Service.AdminService;
import com.Vedika.Service.VisitorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;
    private final AdminService adminService;
    @PostMapping("/visitor/contactUs")
    public ResponseEntity<?> newVisitor(HttpServletRequest httpRequest, @Valid @RequestBody VisitorDto visitorDto){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return this.visitorService.newVisitors(visitorDto);
    }
    @GetMapping("/admin/visitor/getAll")
    public ResponseEntity<?> getAllVisitors(HttpServletRequest httpRequest,
                                            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = "des", required = false) String sortDir,
                                            @RequestParam(value = "actionTaken", defaultValue = "all", required = false) String actionTaken
    ){
        return  new ResponseEntity<>(this.visitorService.getAll(new PageableDto(pageNumber, pageSize, sortBy, sortDir), actionTaken), OK);
    }
    @PutMapping("/admin/visitor/updateRemark/{id}")
    public ResponseEntity<?> updateMyRemark(@PathVariable("id") Long id, @RequestBody RemarksDto remarksDto){
        return this.visitorService.addRemark(id, remarksDto.getRemark(), remarksDto.isCompleted());
    }
    @GetMapping("/admin/visitor/getAllFiltered")
    public ResponseEntity<?> getVisitorsBetweenDates(
            HttpServletRequest httpRequest,
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "createdDate", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "des", required = false) String sortDir,
            @RequestParam(value = "actionTaken", defaultValue = "all", required = false) String actionTaken
    ){
        adminService.trackVisitor(httpRequest.getRemoteAddr());
        return  new ResponseEntity<>(this.visitorService.getVisitorsBetweenDates(startDate, endDate, new PageableDto(pageNumber, pageSize, sortBy, sortDir), actionTaken), OK);
    }
}
