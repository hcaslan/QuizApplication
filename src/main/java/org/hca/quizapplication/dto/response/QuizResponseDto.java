package org.hca.quizapplication.dto.response;

import lombok.Builder;
import org.hca.quizapplication.dto.QuizReadyQuestionDto;

import java.util.List;
import java.util.Map;
@Builder
public record QuizResponseDto(List<QuizReadyQuestionDto> questions, Map<Integer,Integer> correctAnswers) {
}
