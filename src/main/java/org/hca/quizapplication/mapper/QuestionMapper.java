package org.hca.quizapplication.mapper;

import org.hca.quizapplication.dto.request.QuestionCreateRequestDto;
import org.hca.quizapplication.dto.response.QuestionCreateResponseDto;
import org.hca.quizapplication.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class );
    Question questionCreateRequestDtoToQuestion(QuestionCreateRequestDto dto);

    QuestionCreateResponseDto questionToQuestionCreateResponseDto(Question question);
}