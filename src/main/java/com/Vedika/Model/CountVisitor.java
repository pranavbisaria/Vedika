package com.Vedika.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "count_visitor")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CountVisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitorId;
    @Column(name="ip_address")
    private String ipAddress;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDate date;
}
