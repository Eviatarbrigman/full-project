package com.example.question.repository;

import com.example.question.enums.QuestionType;
import com.example.question.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select u from Question u where u.questionType = ?1")
    List<Question> findByCategory(QuestionType questionType);


    @Query("select u from Question u where u.questionType = ?1")
    List<Question> findByCategoryAndNumber(QuestionType questionType);
}
