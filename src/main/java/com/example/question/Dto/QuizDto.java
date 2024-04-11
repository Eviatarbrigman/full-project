package com.example.question.Dto;

public class QuizDto {
    private String categoryName;
    private Integer numberOfQuestions;
    private String title;

    public String getCategoryName() {
        return categoryName;
    }

    public QuizDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public QuizDto setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public QuizDto setTitle(String title) {
        this.title = title;
        return this;
    }
}
