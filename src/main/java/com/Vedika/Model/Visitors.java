package com.Vedika.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Visitors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private Long phoneNumber;
    private Date preferableDate;
    private Date preferableTime;
    private String enquiry;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createdDate;
}
