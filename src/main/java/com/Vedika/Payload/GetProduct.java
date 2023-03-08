package com.Vedika.Payload;

import com.Vedika.Model.Images;
import com.Vedika.Model.Sub;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProduct {
    private Long id;
    private List<Images> imageUrls = new ArrayList<>(0);
    private String modelName;
    private String size;
    private String description;
    private Long ourCost;
    private Long originalPrice;
    private List<Sub> productInfo;
}
