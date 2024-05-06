package org.hca.quizapplication.repository;

import org.hca.quizapplication.entity.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "SELECT * FROM tblquestion ORDER BY RANDOM() LIMIT :questionCount", nativeQuery = true)
    List<Question> getQuestionsLimited(@Param("questionCount") int questionCount);
}
