package com.piggybank.bank.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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
    private Integer id;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private Character gender;
    private LocalDate dob;
    private String email;
}
