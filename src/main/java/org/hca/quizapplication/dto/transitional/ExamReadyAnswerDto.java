package org.hca.quizapplication.dto.transitional;

import lombok.Builder;

@Builder
public record ExamReadyAnswerDto(Integer answerNumber, String answerText) {
}
