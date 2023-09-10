package com.example.aston_task.service;

import com.example.aston_task.answers.DepositAnswer;
import com.example.aston_task.answers.NameWithBalanceAnswer;
import com.example.aston_task.answers.TransferAnswer;
import com.example.aston_task.answers.WithdrawAnswer;
import com.example.aston_task.enams.AnswerStatusEnum;
import com.example.aston_task.entity.BankAccount;
import com.example.aston_task.repository.BankAccountsRepository;
import com.example.aston_task.requests.DepositRequest;
import com.example.aston_task.requests.TransferRequest;
import com.example.aston_task.requests.WithdrawRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountsServiceImpl implements BankAccountsService {

    private final BankAccountsRepository bankAccountsRepository;

    public BankAccountsServiceImpl(BankAccountsRepository bankAccountsRepository) {
        this.bankAccountsRepository = bankAccountsRepository;
    }

    @Override
    public void saveBankAccount(BankAccount bankAccount) {
        bankAccountsRepository.save(bankAccount);
    }

    @Override
    public List<NameWithBalanceAnswer> getAllNameWithBalance() {
        return bankAccountsRepository.findAll().stream()
                .map(bankAccount -> new NameWithBalanceAnswer(bankAccount.getName(), bankAccount.getMoney()))
                .collect(Collectors.toList());
    }

    @Override
    public DepositAnswer deposit(DepositRequest depositRequest) {
        Optional<BankAccount> optionalBankAccount = bankAccountsRepository.findById(depositRequest.getBankAccountId());

        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();
            bankAccount.setMoney(bankAccount.getMoney() + depositRequest.getMoney());
            bankAccountsRepository.save(bankAccount);
            return new DepositAnswer(AnswerStatusEnum.GOOD);

        }

        return new DepositAnswer(AnswerStatusEnum.ACCOUNT_DOES_NOT_EXIST);
    }

    @Override
    public WithdrawAnswer withdraw(WithdrawRequest withdrawRequest) {
        Optional<BankAccount> optionalBankAccount = bankAccountsRepository.findById(withdrawRequest.getBankAccountId());

        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();

            if (bankAccount.getPin() != withdrawRequest.getPin()) {
                return new WithdrawAnswer(AnswerStatusEnum.INCORRECT_PIN);
            }
            if (bankAccount.getMoney() < withdrawRequest.getMoney()) {
                return new WithdrawAnswer(AnswerStatusEnum.INSUFFICIENT_FUNDS);
            }

            bankAccount.setMoney(bankAccount.getMoney() - withdrawRequest.getMoney());
            bankAccountsRepository.save(bankAccount);
            return new WithdrawAnswer(AnswerStatusEnum.GOOD);

        }

        return new WithdrawAnswer(AnswerStatusEnum.ACCOUNT_DOES_NOT_EXIST);
    }

    @Override
    public TransferAnswer transfer(TransferRequest transferRequest) {
        Optional<BankAccount> optionalCurrentBankAccount = bankAccountsRepository.findById(transferRequest.getCurrentBankAccountId());
        Optional<BankAccount> optionalPendingBankAccount = bankAccountsRepository.findById(transferRequest.getPendingBankAccountId());

        if (optionalPendingBankAccount.isEmpty()) {
            return new TransferAnswer(AnswerStatusEnum.ACCOUNT_DOES_NOT_EXIST);
        }
        if (optionalCurrentBankAccount.isEmpty()) {
            return new TransferAnswer(AnswerStatusEnum.ACCOUNT_DOES_NOT_EXIST);
        }

        BankAccount currentBankAccount = optionalCurrentBankAccount.get();
        BankAccount pendingBankAccount = optionalPendingBankAccount.get();

        if (currentBankAccount.getId() == pendingBankAccount.getId()) {
            return new TransferAnswer(AnswerStatusEnum.ACCOUNTS_MATCH);
        }
        if (currentBankAccount.getPin() != transferRequest.getPin()) {
            return new TransferAnswer(AnswerStatusEnum.INCORRECT_PIN);
        }
        if (currentBankAccount.getMoney() < transferRequest.getMoney()) {
            return new TransferAnswer(AnswerStatusEnum.INSUFFICIENT_FUNDS);
        }

        currentBankAccount.setMoney(currentBankAccount.getMoney() - transferRequest.getMoney());
        pendingBankAccount.setMoney(pendingBankAccount.getMoney() + transferRequest.getMoney());

        bankAccountsRepository.save(currentBankAccount);
        bankAccountsRepository.save(pendingBankAccount);

        return new TransferAnswer(AnswerStatusEnum.GOOD);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountsRepository.findAll();
    }

    @Override
    public BankAccount getBankAccount(int id) {
        return bankAccountsRepository.findById(id).orElse(null);
    }

    @Override
    public List<BankAccount> findBankAccountsByName(String name) {
        return bankAccountsRepository.findBankAccountsByName(name);
    }

    @Override
    public void deleteBankAccount(int id) {
        bankAccountsRepository.deleteById(id);
    }
}
