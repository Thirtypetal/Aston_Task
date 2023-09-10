package com.example.aston_task.requests;

import jakarta.validation.constraints.Min;

public class WithdrawRequest {
    @Min(value = 1, message = "bankAccountId")
    private int bankAccountId;

    @Min(value = 1, message = "money")
    private int money;

    @Min(value = 1, message = "pin")
    private int pin;

    public WithdrawRequest() {
    }

    public WithdrawRequest(int bankAccountId, int money, int pin) {
        this.bankAccountId = bankAccountId;
        this.money = money;
        this.pin = pin;
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

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
