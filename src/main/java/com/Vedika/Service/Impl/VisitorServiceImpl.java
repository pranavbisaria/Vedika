package com.Vedika.Service.Impl;
import com.Vedika.Exceptions.ResourceNotFoundException;
import com.Vedika.Model.Visitors;
import com.Vedika.Payload.*;
import com.Vedika.Repository.VisitorsRepo;
import com.Vedika.Service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {
    private final ModelMapper modelMapper;
    private final VisitorsRepo visitorsRepo;
    @Override
    public ResponseEntity<?> newVisitors(VisitorDto visitorDto) {
        Visitors visitors = this.modelMapper.map(visitorDto, Visitors.class);
        this.visitorsRepo.save(visitors);
        return new ResponseEntity<>(new ApiResponse("Form Submitted Successfully", true), OK);
    }
    @Override
    public PageResponse getVisitorsBetweenDates(Date startDate, Date endDate, PageableDto pageable, String actionTaken) {
        Integer pN = pageable.getPageNumber(), pS = pageable.getPageSize();
        Sort sort = null;
        if (pageable.getSortDir().equalsIgnoreCase("asc")) {
            sort = Sort.by(pageable.getSortBy()).ascending();
        } else {
            sort = Sort.by(pageable.getSortBy()).descending();
        }
        Pageable p = PageRequest.of(pN, pS, sort);
        Page<Visitors> pageVisitors;
        if(actionTaken.equals("all")){
            pageVisitors = this.visitorsRepo.findByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(startDate, endDate, p);
        }else if(actionTaken.equals("true")){
            pageVisitors = this.visitorsRepo.findByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqualAndActionTaken(startDate, endDate, true, p);
        }else{
            pageVisitors = this.visitorsRepo.findByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqualAndActionTaken(startDate, endDate, false, p);
        }
        List<Visitors> allVisitors = pageVisitors.getContent();
        return new PageResponse(new ArrayList<>(allVisitors), pageVisitors.getNumber(), pageVisitors.getSize(), pageVisitors.getTotalPages(), pageVisitors.getTotalElements(), pageVisitors.isLast());
    }
    @Override
    public ResponseEntity<?> addRemark(Long id, String Remarks, Boolean isCompleted){
        Visitors visitors = this.visitorsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Visitor Response", "Id: ", id));
        if(Remarks!=null)
            visitors.setRemarks(Remarks);
        if(isCompleted !=null)
            visitors.setActionTaken(isCompleted);
        this.visitorsRepo.save(visitors);
        return new ResponseEntity<>(new ApiResponse("Remarks has been updated successfully!!!", true), OK);
    }
    @Override
    public PageResponse getAll(PageableDto pageable, String actionTaken){
        Integer pN = pageable.getPageNumber(), pS = pageable.getPageSize();
        Sort sort = null;
        if(pageable.getSortDir().equalsIgnoreCase("asc")){
            sort = Sort.by(pageable.getSortBy()).ascending();
        }
        else{
            sort = Sort.by(pageable.getSortBy()).descending();
        }
        Pageable p = PageRequest.of(pN, pS, sort);
        Page<Visitors> pageVisitors;
        if(actionTaken.equals("all")){
            pageVisitors = this.visitorsRepo.findAll(p);
        }else if(actionTaken.equals("true")){
            pageVisitors = this.visitorsRepo.findByActionTaken(true, p);
        }else{
            pageVisitors = this.visitorsRepo.findByActionTaken(false, p);
        }
        List<Visitors> allVisitors = pageVisitors.getContent();
        return new PageResponse(new ArrayList<>(allVisitors), pageVisitors.getNumber(), pageVisitors.getSize(), pageVisitors.getTotalPages(), pageVisitors.getTotalElements(), pageVisitors.isLast());
    }
}
