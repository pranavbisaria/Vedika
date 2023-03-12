package com.Vedika.Service.Impl;
import com.Vedika.Exceptions.ResourceNotFoundException;
import com.Vedika.Model.Product;
import com.Vedika.Model.Visitors;
import com.Vedika.Payload.*;
import com.Vedika.Repository.ProductRepo;
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
    private final ProductRepo productRepo;
    private final VisitorsRepo visitorsRepo;
    @Override
    public ResponseEntity<?> newVisitors(VisitorDto visitorDto, Long smartTvId) {
        Visitors visitors = this.modelMapper.map(visitorDto, Visitors.class);
        if (smartTvId != -1) {
            Product smartTV = this.productRepo.findById(smartTvId).orElseThrow(() -> new ResourceNotFoundException("smartTV", "smartTvID", smartTvId));
            visitors.setProduct(smartTV);
        }
        this.visitorsRepo.save(visitors);
        return new ResponseEntity<>(new ApiResponse("Form Submitted Successfully", true), OK);
    }
    @Override
    public PageResponse getVisitorsBetweenDates(Date startDate, Date endDate, PageableDto pageable) {
        Integer pN = pageable.getPageNumber(), pS = pageable.getPageSize();
        Sort sort = null;
        if (pageable.getSortDir().equalsIgnoreCase("asc")) {
            sort = Sort.by(pageable.getSortBy()).ascending();
        } else {
            sort = Sort.by(pageable.getSortBy()).descending();
        }
        Pageable p = PageRequest.of(pN, pS, sort);
        Page<Visitors> pageVisitors = this.visitorsRepo.findByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(startDate, endDate, p);
        List<Visitors> allVisitors = pageVisitors.getContent();
        List<VisitorDto> allVisitorsDTOs = new ArrayList<>(0);
        for (Visitors visitor : allVisitors) {
            VisitorDto visitorDto = this.modelMapper.map(visitor, VisitorDto.class);
            if (visitor.getProduct() != null)
                visitorDto.getProduct().setImageUrls(visitor.getProduct().getImageUrls().get(0).getImageUrl());
            allVisitorsDTOs.add(visitorDto);
        }
        return new PageResponse(new ArrayList<>(allVisitorsDTOs), pageVisitors.getNumber(), pageVisitors.getSize(), pageVisitors.getTotalPages(), pageVisitors.getTotalElements(), pageVisitors.isLast());
    }
    @Override
    public PageResponse getAll(PageableDto pageable){
        Integer pN = pageable.getPageNumber(), pS = pageable.getPageSize();
        Sort sort = null;
        if(pageable.getSortDir().equalsIgnoreCase("asc")){
            sort = Sort.by(pageable.getSortBy()).ascending();
        }
        else{
            sort = Sort.by(pageable.getSortBy()).descending();
        }
        Pageable p = PageRequest.of(pN, pS, sort);
        Page<Visitors> pageVisitors = this.visitorsRepo.findAll(p);
        List<Visitors> allVisitors = pageVisitors.getContent();
        List<VisitorDto> allVisitorsDTOs = new ArrayList<>(0);
        for (Visitors visitor : allVisitors) {
            VisitorDto visitorDto = this.modelMapper.map(visitor, VisitorDto.class);
            if(visitor.getProduct()!=null)
                visitorDto.getProduct().setImageUrls(visitor.getProduct().getImageUrls().get(0).getImageUrl());
            allVisitorsDTOs.add(visitorDto);
        }
        return new PageResponse(new ArrayList<>(allVisitorsDTOs), pageVisitors.getNumber(), pageVisitors.getSize(), pageVisitors.getTotalPages(), pageVisitors.getTotalElements(), pageVisitors.isLast());
    }
}
