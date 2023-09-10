package com.example.aston_task.requests;

import jakarta.validation.constraints.Min;

public class DepositRequest {
    @Min(value = 1, message = "bankAccountId")
    private int bankAccountId;
    @Min(value = 1, message = "money")

    private int money;

    public DepositRequest() {
    }

    public DepositRequest(int bankAccountId, int money) {
        this.bankAccountId = bankAccountId;
        this.money = money;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
