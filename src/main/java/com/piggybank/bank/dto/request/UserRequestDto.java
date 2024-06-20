package com.piggybank.bank.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

// set all the annotations for getter/setter and constructors with/without args.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
// when we send to website it will show only those parameters whose value is not null
@JsonInclude(JsonInclude.Include.NON_NULL)


// Dto : data transfer object - used to store data that we want to show
public class UserRequestDto {

    // create fields which we want to receive and transfer to different layers
//    @Pattern(regexp = "[0-9]+", message = "'id' can only be positive integer")
    private Integer id;

    @NotNull(message = "'username' cannot be null.")
    private String username;

    @NotNull(message = "'firstName' cannot be null.")
    private String firstName;
    private String middleName;
    private String lastName;

    @NotNull(message = "'gender' cannot be null.")
    private Character gender;

    @NotNull(message = "'dob' cannot be null.")
    private LocalDate dob;
    private String email;

    @NotNull(message = "'accountName' cannot be null.")
    private String accountName;

    @NotNull(message = "'accountType' cannot be null")
    private String accountType;

    @NotNull(message = "'rate of interest' cannnot be null")
    private Float rateOfInterest;

    private Float balance;
}
