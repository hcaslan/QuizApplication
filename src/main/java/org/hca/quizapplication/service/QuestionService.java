package org.hca.quizapplication.service;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.request.QuestionCreateRequestDto;
import org.hca.quizapplication.dto.response.ExamResponseDto;
import org.hca.quizapplication.dto.response.QuestionCreateResponseDto;
import org.hca.quizapplication.entity.Answer;
import org.hca.quizapplication.entity.Question;
import org.hca.quizapplication.mapper.CustomMapper;
import org.hca.quizapplication.mapper.QuestionMapper;
import org.hca.quizapplication.repository.QuestionRepository;
import org.hca.quizapplication.rules.AnswerBusinessRules;
import org.hca.quizapplication.rules.QuestionBusinessRules;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final CustomMapper customMapper;
    private final QuestionBusinessRules questionBusinessRules;
    private final AnswerBusinessRules answerBusinessRules;
    public QuestionCreateResponseDto createQuestion(QuestionCreateRequestDto requestDto) {
        Question question = QuestionMapper.INSTANCE.questionCreateRequestDtoToQuestion(requestDto);
        questionBusinessRules.validateQuestionFieldLengths(question);
        answerBusinessRules.validateCorrectAnswerLogic(question.getAnswers());
        for (Answer answer : question.getAnswers()) {
            answerBusinessRules.validateAnswerFieldLengths(answer);
            answer.setQuestion(question);
        }

        questionRepository.save(question);
        return QuestionMapper.INSTANCE.questionToQuestionCreateResponseDto(question);
    }
    public ExamResponseDto createExam(Integer questionCount) {
        return customMapper.examResponseDtoCreator(questionRepository.findByLimitBy(questionCount));
    }
}
