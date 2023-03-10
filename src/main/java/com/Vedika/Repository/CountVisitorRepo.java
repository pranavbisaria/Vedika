package com.Vedika.Repository;

import com.Vedika.Model.CountVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CountVisitorRepo extends JpaRepository<CountVisitor, String> {
//    Optional<CountVisitor> findByIpAddress(String ipAddress);
    List<CountVisitor> findByDate(Date visitDate);
    boolean existsByDateAndIpAddress(LocalDate visitDate, String ipAddress);
}
