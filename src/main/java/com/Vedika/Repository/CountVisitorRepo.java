package com.Vedika.Repository;

import com.Vedika.Model.CountVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CountVisitorRepo extends JpaRepository<CountVisitor, String> {
//    Optional<CountVisitor> findByIpAddress(String ipAddress);
    List<CountVisitor> findByDate(Date visitDate);
    boolean existsByDateAndIpAddress(LocalDate visitDate, String ipAddress);
    @Query("SELECT COUNT(DISTINCT cv.ipAddress) FROM CountVisitor cv")
    int countDistinctByIpAddress();
}
