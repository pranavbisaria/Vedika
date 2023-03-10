package com.Vedika.Payload;
import com.Vedika.Model.Sub;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProduct {
    private String modelName;
    private String size;
    private String description;
    private Long ourCost;
    private Long originalPrice;
    private List<Sub> productInfo;
}
