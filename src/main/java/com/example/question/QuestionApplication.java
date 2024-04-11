package com.example.question;

import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class QuestionApplication {
    @Autowired
    QuestionService questionService;

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);

    }
    @Component
    public class init implements CommandLineRunner{

        @Override
        public void run(String... args) {
            questionService.createQuestions();
        }
    }
}


