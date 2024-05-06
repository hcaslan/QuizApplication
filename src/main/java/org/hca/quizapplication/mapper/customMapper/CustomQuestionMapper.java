package org.hca.quizapplication.mapper.customMapper;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.QuizReadyAnswerDto;
import org.hca.quizapplication.dto.QuizReadyQuestionDto;
import org.hca.quizapplication.entity.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomQuestionMapper {
    private final CustomAnswerMapper customAnswerMapper;

    public List<QuizReadyQuestionDto> questionListToQuizReadyQuestionDtoList(List<Question> questionList) {
        List<QuizReadyQuestionDto> quizReadyQuestionDtoList = new ArrayList<>();
        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            List<QuizReadyAnswerDto> readyAnswers = customAnswerMapper.answerListToQuizReadyAnswerDtoList(question.getAnswers());
            quizReadyQuestionDtoList.add(new QuizReadyQuestionDto(i + 1, question.getQuestionText(), readyAnswers));
        }
        return quizReadyQuestionDtoList;
    }
}