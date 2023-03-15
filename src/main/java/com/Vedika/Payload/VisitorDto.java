package com.Vedika.Payload;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDto {
    @NotNull
    private String firstname;
    @Nullable
    private String lastname;
    @NotNull
    @Pattern(regexp="^(\\+\\d{2}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Not a valid number, please enter a 10 digit valid mobile number")
    private String phoneNumber;
    @Email
    @Nullable
    private String email;
    @Nullable
    private String address;
    @Nullable
    private String sizeReq;
    @Nullable
    private Long quantityReq;
    @Nullable
    private String enquiry;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdDate;
    @Nullable
    private String remarks;
    private boolean actionTaken = false;
}
