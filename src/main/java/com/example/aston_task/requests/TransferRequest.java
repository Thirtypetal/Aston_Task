package com.example.aston_task.requests;

import jakarta.validation.constraints.Min;

public class TransferRequest {
    @Min(value = 1, message = "currentBankAccountId")
    private int currentBankAccountId;

    @Min(value = 1, message = "pendingBankAccountId")
    private int pendingBankAccountId;

    @Min(value = 1, message = "money")
    private int money;

    @Min(value = 1, message = "pin")
    private int pin;

    public TransferRequest() {
    }

    public TransferRequest(int currentBankAccountId, int pendingBankAccountId, int money, int pin) {
        this.currentBankAccountId = currentBankAccountId;
        this.pendingBankAccountId = pendingBankAccountId;
        this.money = money;
        this.pin = pin;
    }

    public int getCurrentBankAccountId() {
        return currentBankAccountId;
    }

    public void setCurrentBankAccountId(int currentBankAccountId) {
        this.currentBankAccountId = currentBankAccountId;
    }

    public int getPendingBankAccountId() {
        return pendingBankAccountId;
    }

    public void setPendingBankAccountId(int pendingBankAccountId) {
        this.pendingBankAccountId = pendingBankAccountId;
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
