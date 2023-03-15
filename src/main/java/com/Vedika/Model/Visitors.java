package com.Vedika.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String firstname;
    private String lastname;
    @NotNull
    private Long phoneNumber;
    private String email;
    private String address;
    private String sizeReq;
    private Long quantityReq;
    private String enquiry;
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(updatable = false, nullable = false)
    private Date createdDate;
    @Column(length = 10000)
    private String remarks;
    private boolean actionTaken = false;
}
