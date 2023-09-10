package com.example.aston_task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pin")
    private int pin;

    @Column(name = "money")
    private int money;


    public BankAccount() {

    }

    public BankAccount(String name, int pin, int money) {
        this.name = name;
        this.pin = pin;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int bankAccountId) {
        this.id = bankAccountId;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BankAccounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", pin=" + pin +
                '}';
    }
}
