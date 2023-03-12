package com.Vedika.Service.Impl;

import com.Vedika.Model.CountVisitor;
import com.Vedika.Repository.CountVisitorRepo;
import com.Vedika.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class AdminServicesImpl implements AdminService {

    private final CountVisitorRepo countVisitorRepo;

    @Override
    @Async
    public void trackVisitor(String ipAddress) {
        boolean alreadyVisited = countVisitorRepo.existsByDateAndIpAddress(LocalDate.now(), ipAddress);
        if (!alreadyVisited){
            CountVisitor visitor = new CountVisitor();
            visitor.setIpAddress(ipAddress);
            countVisitorRepo.save(visitor);
        }
    }
    @Override
    public Map<LocalDate, Integer> getVisitorCount() {
        List<CountVisitor> totalVisitors = countVisitorRepo.findAll();
        Map<LocalDate, Integer> ipCountByDate = new HashMap<>();
        for (CountVisitor totalVisitor : totalVisitors) {
            LocalDate date = totalVisitor.getDate();
            if (ipCountByDate.containsKey(date)) {
                int count = ipCountByDate.get(date);
                ipCountByDate.put(date, count + 1);
            } else {
                ipCountByDate.put(date, 1);
            }
        }
        return ipCountByDate;
    }
}
