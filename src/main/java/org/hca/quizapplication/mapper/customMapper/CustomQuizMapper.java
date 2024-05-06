package org.hca.quizapplication.mapper.customMapper;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.response.QuizResponseDto;
import org.hca.quizapplication.dto.QuizReadyQuestionDto;
import org.hca.quizapplication.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
@RequiredArgsConstructor
public class CustomQuizMapper {

    private final CustomQuestionMapper customQuestionMapper;
    private final CustomAnswerMapper customAnswerMapper;

    public QuizResponseDto createQuizResponse(List<Question> questions) {
        List<QuizReadyQuestionDto> readyQuestions = customQuestionMapper.questionListToQuizReadyQuestionDtoList(questions);
        Map<Integer, Integer> correctAnswers = customAnswerMapper.createCorrectAnswersMap(questions);
        return new QuizResponseDto(readyQuestions, correctAnswers);
    }
}

