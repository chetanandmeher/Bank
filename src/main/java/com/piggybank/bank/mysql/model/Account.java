package com.piggybank.bank.mysql.model;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

// make this class with Entity annotation to show it as a table connected to database
@Entity
@Table(name = "accounts")
public class Account {

    // create fields according to the 'accounts' table
    // assign the fields with the 'accounts' table respective columns names with column annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "rate_of_interest")
    private DecimalFormat rateOfInterest;

    @Column(name = "balance")
    private DecimalFormat balance;

    @Column(name="created_by")
    private Integer createdBy;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_by")
    private Integer updatedBy;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;



}
