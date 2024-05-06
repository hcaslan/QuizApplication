package org.hca.quizapplication.dto;

import lombok.Builder;

@Builder
public record QuizReadyAnswerDto(Integer answerNumber, String answerText) {
}
