package com.piggybank.bank.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

// set all the annotations for getter/setter and constructors with/without args.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
// when we send to website it will show only those parameters whose value is not null
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserResponseDto {

    private Integer id;
    private String username;
    private String fullName;
}
