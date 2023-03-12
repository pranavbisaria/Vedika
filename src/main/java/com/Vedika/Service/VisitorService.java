package com.Vedika.Service;

import com.Vedika.Payload.PageResponse;
import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.VisitorDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface VisitorService {
    ResponseEntity<?> newVisitors(VisitorDto visitorDto, Long smartTvId);

    PageResponse getVisitorsBetweenDates(Date startDate, Date endDate, PageableDto pageable);

    PageResponse getAll(PageableDto pageable);
}
