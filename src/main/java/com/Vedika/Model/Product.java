package com.Vedika.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Images> imageUrls = new ArrayList<>(0);
    private String modelName;
    private String size;
    @Column(length = 10000)
    private String description;
    private Long ourCost;
    private Long originalPrice;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sub> productInfo;
}
