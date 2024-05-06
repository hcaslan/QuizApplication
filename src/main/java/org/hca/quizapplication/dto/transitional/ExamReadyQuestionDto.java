package org.hca.quizapplication.dto.transitional;

import lombok.Builder;
import org.hca.quizapplication.dto.response.AnswerResponseDto;

import java.util.List;
@Builder
public record ExamReadyQuestionDto(Integer questionNumber, String questionText, List<ExamReadyAnswerDto> answers) {
}
