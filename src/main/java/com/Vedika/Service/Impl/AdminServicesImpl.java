package com.Vedika.Service.Impl;

import com.Vedika.Model.CountVisitor;
import com.Vedika.Repository.CountVisitorRepo;
import com.Vedika.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminServicesImpl implements AdminService {

    private final CountVisitorRepo countVisitorRepo;

    @Override
    @Async
    public void trackVisitor(String ipAddress) {
        Optional<CountVisitor> countVisitor =countVisitorRepo.findByIpAddress(ipAddress);
        CountVisitor visitor;
        if (countVisitor.isPresent()) {
            visitor = countVisitor.get();
            visitor.setVisitCount(visitor.getVisitCount() + 1);
        } else {
            visitor = new CountVisitor(ipAddress, 1);
        }
        countVisitorRepo.save(visitor);
    }

    @Override
    public int getVisitorCount() {
        return (int)countVisitorRepo.count();
    }
}
