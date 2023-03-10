package com.Vedika.Repository;

import com.Vedika.Model.CountVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountVisitorRepo extends JpaRepository<CountVisitor, String> {
    Optional<CountVisitor> findByIpAddress(String ipAddress);
}
