package com.example.question.service;

import com.example.question.Dto.QuestionDto;
import com.example.question.Dto.ScoreDto;
import com.example.question.enums.QuestionType;
import com.example.question.model.Question;
import com.example.question.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ModelMapper modelMapper;


    public Question createQuestion(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        return questionRepository.save(question);
    }

    public List<QuestionDto> getAllQuestions() {
        List<Question> questionFromDb = questionRepository.findAll();
        return questionFromDb.stream().map(question -> modelMapper.map(question, QuestionDto.class)).toList();
    }

    public void createQuestions() {
        List<Question> questionsFromDB = questionRepository.findAll();

        List<Question> questionsToCreate = Arrays.asList(
                new Question("Which one of the following is not a Java feature?", "Object Oriented", "Use of pointers", "Portable", "SecuDynamic and Extensiblered", "Use of pointers", QuestionType.JAVA),
                new Question("What are the fundamental principles of object oriented programming?", "Inheritance", "Simple", "Polymorphism", "Encapsulation", "Inheritance", QuestionType.JAVA),
                new Question("Who invented Java Programming??", "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "James Gosling", QuestionType.JAVA),
                new Question("Which statement is true about Java?", "Java is a sequence-dependent programming language", "Java is a code dependent programming language", "Java is a platform-dependent programming language", "Java is a platform-independent programming language", "Java is a platform-independent programming language", QuestionType.JAVA),
                new Question("Which component is used to compile, debug and execute the java programs?", "JRE", "JIT", "JDK", "JVM", "JDK", QuestionType.JAVA),
                new Question("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "keyword", "none of the mentioned", "keyword", QuestionType.JAVA),
                new Question("What is the extension of java code files?", ".js", ".txt", ".class", ".java", ".java", QuestionType.JAVA),
                new Question("Which environment variable is used to set the java path?", "MAVEN_Path", "JavaPATH", "JAVA", "JAVA_HOME", "JAVA_HOME", QuestionType.JAVA)
        );

        List<Question> newQuestions = questionsToCreate.stream()
                .filter(question -> !questionsFromDB.contains(question))
                .toList();

        questionRepository.saveAll(newQuestions);
    }

    public List<Question> findByCategory(String type) {
        List<Question> questions = questionRepository.findByCategory(QuestionType.valueOf(type));
        return questions;
    }

    public List<Question> findByCategoryAndNumber(String type, Integer numOfQuestion) {
        return questionRepository.findByCategoryAndNumber(QuestionType.valueOf(type)).stream()
                .unordered().limit(numOfQuestion)
                .collect(Collectors.toList());
    }

//    public Integer getScore(ScoreDto scoreDto) {
//        int pointsForCorrectAnswer = 100 / scoreDto.getQuestionList().size();
//        int finalScore = 0;
//        List<Question> questionFromDb = questionRepository.findAll();
//        for (Map.Entry<Integer, String> entry : scoreDto.getQuestionList().entrySet()) {
//            Integer questionId = entry.getKey();
//            String answer = entry.getValue();
//            for (Question currentQuestion : questionFromDb) {
//                if (currentQuestion.getId().equals(questionId) && currentQuestion.getCorrectAnswer().equals(answer)) {
//                    finalScore += pointsForCorrectAnswer;
//                    break;
//                }
//            }
//        }
//        return finalScore;
//    }

    public Integer getScore(ScoreDto scoreDto) {
        int pointsForCorrectAnswer = 100 / scoreDto.getQuestionList().size();
        List<Question> questionFromDb = questionRepository.findAll();

        return scoreDto.getQuestionList().entrySet().stream().mapToInt(value -> {
           int questionId = value.getKey();
           String answer = value.getValue();
           return questionFromDb.stream().filter(question -> question.getId().equals(questionId))
                   .findFirst()
                   .map(currentQuestion -> currentQuestion.getCorrectAnswer().equals(answer) ? pointsForCorrectAnswer : 0)
                   .orElse(0);
        }).sum();
    }

    public List<Question> getAllQuestionsByIds(List<Integer> qusetionsIds) {
        return questionRepository.findAllById(qusetionsIds);
    }
}
