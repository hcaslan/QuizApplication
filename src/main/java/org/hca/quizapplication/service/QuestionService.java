package org.hca.quizapplication.service;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.request.QuestionCreateRequestDto;
import org.hca.quizapplication.dto.response.QuestionCreateResponseDto;
import org.hca.quizapplication.dto.response.QuestionResponseDto;
import org.hca.quizapplication.entity.Answer;
import org.hca.quizapplication.entity.Question;
import org.hca.quizapplication.mapper.QuestionMapper;
import org.hca.quizapplication.repository.QuestionRepository;
import org.hca.quizapplication.rules.AnswerBusinessRules;
import org.hca.quizapplication.rules.QuestionBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final QuestionBusinessRules questionBusinessRules;
    private final AnswerBusinessRules answerBusinessRules;
    public QuestionCreateResponseDto createQuestion(QuestionCreateRequestDto requestDto) {
        Question question = QuestionMapper.INSTANCE.questionCreateRequestDtoToQuestion(requestDto);
        answerBusinessRules.checkIfListValid(requestDto.answers());
        questionBusinessRules.validateQuestionFieldLengths(question);
        answerBusinessRules.validateCorrectAnswerLogic(question.getAnswers());

        for (Answer answer : question.getAnswers()) {
            answerBusinessRules.validateAnswerFieldLengths(answer);
            answer.setQuestion(question);
        }
        questionRepository.save(question);
        return QuestionMapper.INSTANCE.questionToQuestionCreateResponseDto(question);
    }
    public List<Question> getQuestionsLimited(Integer questionCount) {
        return questionRepository.getQuestionsLimited(questionCount);
    }
    public List<QuestionResponseDto> findAllQuestions() {
        return questionRepository.findAll().stream().map(QuestionMapper.INSTANCE::questionToQuestionResponseDto).collect(Collectors.toList());
    }

    public QuestionResponseDto findQuestionById(Long id) {
        questionBusinessRules.checkIfExistsById(id);

        return QuestionMapper.INSTANCE.questionToQuestionResponseDto(questionRepository.findById(id).get());
    }
}
