package com.example.question.controller;

import com.example.question.Dto.QuestionDto;
import com.example.question.Dto.QuizDto;
import com.example.question.Dto.ScoreDto;
import com.example.question.model.Question;
import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public ResponseEntity<List<QuestionDto>> getQuestions() {
        List<QuestionDto> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/category/{type}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String type) {
        List<Question> questions = questionService.findByCategory(type);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDto questionDto) {
        Question returnQuestion = questionService.createQuestion(questionDto);
        return new ResponseEntity<>(returnQuestion, HttpStatus.OK);
    }

    @PostMapping("/generate")
    public ResponseEntity<List<Question>> getQuestionsForQuiz(@RequestBody QuizDto quizDto) {
        List<Question> questions = questionService.findByCategoryAndNumber(quizDto.getCategoryName(), quizDto.getNumberOfQuestions());
        
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/score")
    public ResponseEntity<Integer> getScoreForQuiz (@RequestBody ScoreDto scoreDto){
        Integer score = questionService.getScore(scoreDto);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
    @PostMapping("/getQuestionsById")
    public ResponseEntity<List<Question>> getQuestionsById (@RequestBody List<Integer> qusetionsIds){
        List<Question> questionsList = questionService.getAllQuestionsByIds(qusetionsIds);
       return new ResponseEntity<>(questionsList,HttpStatus.OK);
    }
}
