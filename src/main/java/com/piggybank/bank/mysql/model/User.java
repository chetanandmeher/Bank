package com.piggybank.bank.mysql.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// make this class with Entity annotation to show it as a table connected to database
@Entity
@Table(name = "users")
public class User {

    // create filed according to the 'users' table
    // assign the fields with the 'users' respective columns names with column annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="gender")
    private Character gender;

    @Column(name="dob")
    private LocalDate dob;

    @Column(name="email")
    private String email;

    @Column(name="created_by")
    private Integer createdBy;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_by")
    private Integer updatedBy;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
