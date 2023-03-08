package com.Vedika.Repository;
import com.Vedika.Model.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorsRepo extends JpaRepository<Visitors, Long> {
}
