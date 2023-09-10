package com.example.aston_task.repository;

import com.example.aston_task.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountsRepository extends JpaRepository<BankAccount, Integer> {
    List<BankAccount> findBankAccountsByName(String name);
}
