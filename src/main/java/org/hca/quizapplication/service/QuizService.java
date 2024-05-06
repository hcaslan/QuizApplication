package org.hca.quizapplication.service;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.response.QuizResponseDto;
import org.hca.quizapplication.mapper.customMapper.CustomQuizMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final CustomQuizMapper customQuizMapper;
    private final QuestionService questionService;
    public QuizResponseDto createQuiz(Integer questionCount) {
        return customQuizMapper.createQuizResponse(questionService.getQuestionsLimited(questionCount));
    }
}
