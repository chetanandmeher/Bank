package com.piggybank.bank.repository;


import com.piggybank.bank.mysql.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
