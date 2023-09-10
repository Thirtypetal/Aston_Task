package com.example.aston_task.controller;

import com.example.aston_task.answers.*;
import com.example.aston_task.enams.AnswerStatusEnum;
import com.example.aston_task.entity.BankAccount;
import com.example.aston_task.requests.AddNewBankAccountRequest;
import com.example.aston_task.requests.DepositRequest;
import com.example.aston_task.requests.TransferRequest;
import com.example.aston_task.requests.WithdrawRequest;
import com.example.aston_task.service.BankAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final BankAccountsService bankAccountsService;

    public Controller(BankAccountsService bankAccountsService) {
        this.bankAccountsService = bankAccountsService;
    }

    @PutMapping("/addBankAccount")
    public AddNewBankAccountAnswer addNewBankAccount(@RequestBody @Valid AddNewBankAccountRequest addNewBankAccountRequest) {
        BankAccount bankAccount = new BankAccount(
                addNewBankAccountRequest.getName(),
                addNewBankAccountRequest.getPin(),
                0);
        bankAccountsService.saveBankAccount(bankAccount);
        return new AddNewBankAccountAnswer(AnswerStatusEnum.GOOD);
    }

    @GetMapping("/bankAccounts")
    public List<NameWithBalanceAnswer> getAllNameWithBalance() {
        return bankAccountsService.getAllNameWithBalance();
    }

    @PostMapping("/deposit")
    public DepositAnswer deposit(@RequestBody @Valid DepositRequest depositRequest) {
        return bankAccountsService.deposit(depositRequest);
    }

    @PostMapping("/withdraw")
    public WithdrawAnswer withdraw(@RequestBody @Valid WithdrawRequest withdrawRequest) {
        return bankAccountsService.withdraw(withdrawRequest);
    }

    @PostMapping("/transfer")
    public TransferAnswer transfer(@RequestBody @Valid TransferRequest transferRequest) {
        return bankAccountsService.transfer(transferRequest);
    }

    @GetMapping("/bankAccountsFullInfo")
    public List<BankAccount> showAllBankAccounts() {
        return bankAccountsService.getAllBankAccounts();
    }

    @GetMapping("/bankAccountFullInfo/{bankAccountId}")
    public BankAccount getBankAccount(@PathVariable @Min(1) int bankAccountId) {
        return bankAccountsService.getBankAccount(bankAccountId);
    }

    @GetMapping("/bankAccountFullInfo/name/{name}")
    public List<BankAccount> showBankAccounts(@PathVariable @NotBlank String name) {
        return bankAccountsService.findBankAccountsByName(name);
    }

    @DeleteMapping("/deleteBankAccount/{bankAccountId}")
    public void deleteBankAccount(@PathVariable @Min(1) int bankAccountId) {
        bankAccountsService.deleteBankAccount(bankAccountId);
    }
}
