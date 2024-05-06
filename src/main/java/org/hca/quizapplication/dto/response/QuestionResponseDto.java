package org.hca.quizapplication.dto.response;

import java.util.List;

public record QuestionResponseDto(Long id, String questionText, List<AnswerResponseDto> answers) {
}
