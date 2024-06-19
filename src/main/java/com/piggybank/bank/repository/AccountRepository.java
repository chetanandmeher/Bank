package com.piggybank.bank.repository;

import com.piggybank.bank.mysql.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Integer> {
}
