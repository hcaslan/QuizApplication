package org.hca.quizapplication.dto.request;

import lombok.Builder;
import org.hca.quizapplication.dto.response.AnswerResponseDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Builder
public record QuestionCreateRequestDto(
        String questionText,
        List<AnswerResponseDto> answers) {
}
