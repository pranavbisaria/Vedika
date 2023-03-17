package com.Vedika.Service;

import com.Vedika.Payload.PageResponse;
import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.VisitorDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface VisitorService {
    ResponseEntity<?> newVisitors(VisitorDto visitorDto);

    PageResponse getVisitorsBetweenDates(Date startDate, Date endDate, PageableDto pageable, String actionTaken);

    ResponseEntity<?> addRemark(Long id, String Remarks, Boolean isCompleted);

    PageResponse getAll(PageableDto pageable, String actionTaken);
}
