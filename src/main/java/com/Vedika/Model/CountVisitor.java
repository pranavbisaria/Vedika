package com.Vedika.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountVisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitorId;
    private String ipAddress;
//    @Temporal(TemporalType.DATE)
    private LocalDate date;
}
