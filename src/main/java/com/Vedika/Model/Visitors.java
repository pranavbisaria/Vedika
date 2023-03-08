package com.Vedika.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
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
}
