package com.example.aston_task.service;

import com.example.aston_task.answers.DepositAnswer;
import com.example.aston_task.answers.NameWithBalanceAnswer;
import com.example.aston_task.answers.TransferAnswer;
import com.example.aston_task.answers.WithdrawAnswer;
import com.example.aston_task.entity.BankAccount;
import com.example.aston_task.requests.DepositRequest;
import com.example.aston_task.requests.TransferRequest;
import com.example.aston_task.requests.WithdrawRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BankAccountsService {

    void saveBankAccount(BankAccount employee);

    List<NameWithBalanceAnswer> getAllNameWithBalance();

    DepositAnswer deposit(@RequestBody DepositRequest depositRequest);

    WithdrawAnswer withdraw(@RequestBody WithdrawRequest withdrawRequest);

    TransferAnswer transfer(@RequestBody TransferRequest transferRequest);

    List<BankAccount> getAllBankAccounts();

    List<BankAccount> findBankAccountsByName(String name);

    BankAccount getBankAccount(int id);

    void deleteBankAccount(int id);
}
