package com.example.question.model;


import com.example.question.enums.QuestionType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "question",schema = "my_schema")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;


    public Question() {

    }
    public Question(String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer, QuestionType questionType) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.questionType = questionType;
    }

    public Integer getId() {
        return id;
    }

    public Question setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer1() {
        return answer1;
    }

    public Question setAnswer1(String answer1) {
        this.answer1 = answer1;
        return this;
    }

    public String getAnswer2() {
        return answer2;
    }

    public Question setAnswer2(String answer2) {
        this.answer2 = answer2;
        return this;
    }

    public String getAnswer3() {
        return answer3;
    }

    public Question setAnswer3(String answer3) {
        this.answer3 = answer3;
        return this;
    }

    public String getAnswer4() {
        return answer4;
    }

    public Question setAnswer4(String answer4) {
        this.answer4 = answer4;
        return this;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Question setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Question setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer1, question1.answer1) && Objects.equals(answer2, question1.answer2) && Objects.equals(answer3, question1.answer3) && Objects.equals(answer4, question1.answer4) && Objects.equals(correctAnswer, question1.correctAnswer) && questionType == question1.questionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer1, answer2, answer3, answer4, correctAnswer, questionType);
    }
}
