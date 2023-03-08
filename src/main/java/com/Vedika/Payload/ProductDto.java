package com.Vedika.Payload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String imageUrls;
    private String modelName;
    private String size;
    private Long ourCost;
    private Long originalPrice;
}
