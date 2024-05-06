package org.hca.quizapplication.dto.request;

import lombok.Builder;
import org.hca.quizapplication.dto.response.AnswerResponseDto;

import java.util.List;

@Builder
public record QuestionCreateRequestDto(String questionText, List<AnswerRequestDto> answers) {
}
