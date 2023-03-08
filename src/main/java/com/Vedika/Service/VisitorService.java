package com.Vedika.Service;

import com.Vedika.Payload.PageResponse;
import com.Vedika.Payload.PageableDto;
import com.Vedika.Payload.VisitorDto;
import org.springframework.http.ResponseEntity;

public interface VisitorService {
    ResponseEntity<?> newVisitors(VisitorDto visitorDto, Long smartTvId);
    PageResponse getAll(PageableDto pageable);
}
