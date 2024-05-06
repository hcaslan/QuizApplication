package org.hca.quizapplication.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record QuestionCreateResponseDto(String questionText, List<AnswerResponseDto> answers) {
}
