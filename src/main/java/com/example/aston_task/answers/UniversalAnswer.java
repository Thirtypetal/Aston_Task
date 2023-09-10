package com.example.aston_task.answers;

import com.example.aston_task.enams.AnswerStatusEnum;

public class UniversalAnswer {
    AnswerStatusEnum answerStatusEnum;

    public UniversalAnswer(AnswerStatusEnum answerStatusEnum) {
        this.answerStatusEnum = answerStatusEnum;
    }

    public AnswerStatusEnum getAnswerStatusEnam() {
        return answerStatusEnum;
    }

    public void setAnswerStatusEnam(AnswerStatusEnum answerStatusEnum) {
        this.answerStatusEnum = answerStatusEnum;
    }
}
