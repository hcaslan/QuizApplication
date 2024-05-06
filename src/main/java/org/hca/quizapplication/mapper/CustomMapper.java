package org.hca.quizapplication.mapper;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.response.ExamResponseDto;
import org.hca.quizapplication.dto.transitional.ExamReadyAnswerDto;
import org.hca.quizapplication.dto.transitional.ExamReadyQuestionDto;
import org.hca.quizapplication.entity.Answer;
import org.hca.quizapplication.entity.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class CustomMapper {
    public ExamResponseDto examResponseDtoCreator(List<Question> questions){
        List<ExamReadyQuestionDto> readyQuestions = new ArrayList<ExamReadyQuestionDto>();
        Map<Integer,Integer> correctAnswers = new HashMap<Integer, Integer>();
        for (int i = 0; i < questions.size(); i++ ) {
            Question question = questions.get(i);
            List<ExamReadyAnswerDto> readyAnswers = new ArrayList<>();
            int correctAnswer = 0;
            for (int j = 0; j < question.getAnswers().size(); j++) {
                Answer answer = question.getAnswers().get(j);
                readyAnswers.add(ExamReadyAnswerDto.builder()
                        .answerNumber(j+1)
                        .answerText(answer.getAnswerText())
                        .build());
                if(answer.isCorrectAnswer()) {
                    correctAnswer=j+1;
                }
            }
            readyQuestions.add(ExamReadyQuestionDto.builder()
                    .questionNumber(i+1)
                    .questionText(question.getQuestionText())
                    .answers(readyAnswers)
                    .build());
            correctAnswers.put(i+1,correctAnswer);
        }
        return ExamResponseDto.builder()
                .correctAnswers(correctAnswers)
                .questions(readyQuestions)
                .build();
    }
}
