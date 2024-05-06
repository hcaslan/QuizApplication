package org.hca.quizapplication.dto.response;

import lombok.Builder;
import org.hca.quizapplication.dto.transitional.ExamReadyQuestionDto;

import java.util.List;
import java.util.Map;
@Builder
public record ExamResponseDto(List<ExamReadyQuestionDto> questions, Map<Integer,Integer> correctAnswers) {
}
