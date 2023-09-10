package com.example.aston_task.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AddNewBankAccountRequest {
    @NotBlank
    private String name;

    @Min(value = 1, message = "pin")
    private int pin;

    public AddNewBankAccountRequest() {
    }

    public AddNewBankAccountRequest(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
