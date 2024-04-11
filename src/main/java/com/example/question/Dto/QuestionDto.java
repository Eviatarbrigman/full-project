package com.example.question.Dto;

public class QuestionDto {
    private Integer id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    public Integer getId() {
        return id;
    }

    public QuestionDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionDto setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer1() {
        return answer1;
    }

    public QuestionDto setAnswer1(String answer1) {
        this.answer1 = answer1;
        return this;
    }

    public String getAnswer2() {
        return answer2;
    }

    public QuestionDto setAnswer2(String answer2) {
        this.answer2 = answer2;
        return this;
    }

    public String getAnswer3() {
        return answer3;
    }

    public QuestionDto setAnswer3(String answer3) {
        this.answer3 = answer3;
        return this;
    }

    public String getAnswer4() {
        return answer4;
    }

    public QuestionDto setAnswer4(String answer4) {
        this.answer4 = answer4;
        return this;
    }
}
