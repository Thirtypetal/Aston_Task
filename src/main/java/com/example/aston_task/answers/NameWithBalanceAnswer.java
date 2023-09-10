package com.example.aston_task.answers;

import com.example.aston_task.enams.AnswerStatusEnum;

public class NameWithBalanceAnswer {
    private String name;

    private int money;

    public NameWithBalanceAnswer() {
    }

    public NameWithBalanceAnswer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
