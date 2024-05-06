package org.hca.quizapplication.rules;


import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.entity.Question;
import org.hca.quizapplication.exception.ErrorType;
import org.hca.quizapplication.exception.ValidationException;
import org.hca.quizapplication.repository.QuestionRepository;
import org.hca.quizapplication.util.BusinessRulesManager;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
@Service
@RequiredArgsConstructor
public class QuestionBusinessRules extends BusinessRulesManager {
    private final QuestionRepository questionRepository;
    public void validateQuestionFieldLengths(Question question){
        try{
            Field questionTextField = question.getClass().getDeclaredField("questionText");
            validateFieldLength(question.getQuestionText(),questionTextField);
        }catch (NoSuchFieldException e){
            throw new ValidationException(ErrorType.FIELD_ERROR);
        }
    }
    public void checkIfExistsById(Long id) {
        if (!questionRepository.existsById(id)) throw new ValidationException(ErrorType.NOT_FOUND);
    }
}
