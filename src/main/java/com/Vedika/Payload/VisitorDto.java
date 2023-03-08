package com.Vedika.Payload;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDto {
    private String firstname;
    @Nullable
    private String lastname;
    @Nullable
    private String address;
    @Email
    @Nullable
    private String email;
    @NotNull
    @Pattern(regexp="^(\\+\\d{2}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Not a valid number, please enter a 10 digit valid mobile number")
    private Long phoneNumber;
    @Nullable
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date preferableDate;
    @Nullable
    @JsonFormat(pattern = "hh:mm")
    private Date preferableTime;
    @Nullable
    private String enquiry;
    @Nullable
    private ProductDto product;
}
