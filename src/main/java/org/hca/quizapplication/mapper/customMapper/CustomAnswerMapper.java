package org.hca.quizapplication.mapper.customMapper;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.QuizReadyAnswerDto;
import org.hca.quizapplication.entity.Answer;
import org.hca.quizapplication.entity.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CustomAnswerMapper {
    public List<QuizReadyAnswerDto> answerListToQuizReadyAnswerDtoList(List<Answer> answerList) {
        List<QuizReadyAnswerDto> readyAnswers = new ArrayList<>();
        for (int j = 0; j < answerList.size(); j++) {
            Answer answer = answerList.get(j);
            readyAnswers.add(new QuizReadyAnswerDto(j + 1, answer.getAnswerText()));
        }
        return readyAnswers;
    }
    public Map<Integer, Integer> createCorrectAnswersMap(List<Question> questions) {
        Map<Integer, Integer> correctAnswers = new HashMap<>();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            int correctAnswer = extractCorrectAnswer(question.getAnswers());
            correctAnswers.put(i + 1, correctAnswer);
        }
        return correctAnswers;
    }

    private int extractCorrectAnswer(List<Answer> answers) {
        for (int j = 0; j < answers.size(); j++) {
            Answer answer = answers.get(j);
            if (answer.isCorrectAnswer()) {
                return j + 1;
            }
        }
        return 0;
    }
}
