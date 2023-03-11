package com.Vedika.Controller;

import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.VisitorDto;
import com.Vedika.Service.VisitorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;
    @PostMapping("/visitor/contactUs/{smartTvId}")
    public ResponseEntity<?> newVisitor(@Valid @RequestBody VisitorDto visitorDto, @PathVariable("smartTvId") Long smartTvId){
        return this.visitorService.newVisitors(visitorDto, smartTvId);
    }
    @GetMapping("/admin/visitor/getAll")
    public ResponseEntity<?> getAllVisitors(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = "productId", required = false) String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = "des", required = false) String sortDir
    ){
        return  new ResponseEntity<>(this.visitorService.getAll(new PageableDto(pageNumber, pageSize, sortBy, sortDir)), OK);
    }
}
