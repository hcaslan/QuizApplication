package org.hca.quizapplication.dto;

import lombok.Builder;

import java.util.List;
@Builder
public record QuizReadyQuestionDto(Integer questionNumber, String questionText, List<QuizReadyAnswerDto> answers) {
}
