package com.Vedika.Repository;
import com.Vedika.Model.Visitors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
@Repository
public interface VisitorsRepo extends JpaRepository<Visitors, Long> {
    Page<Visitors> findByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Date startDate, Date endDate, Pageable pageable);
}
