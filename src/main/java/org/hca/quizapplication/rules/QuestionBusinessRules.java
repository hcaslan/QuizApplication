package org.hca.quizapplication.rules;


import org.hca.quizapplication.entity.Question;
import org.hca.quizapplication.exception.ErrorType;
import org.hca.quizapplication.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
@Service
public class QuestionBusinessRules extends BusinessRulesManager{
    public void validateQuestionFieldLengths(Question question){
        try{
            Field questionTextField = question.getClass().getDeclaredField("questionText");
            validateFieldLength(question.getQuestionText(),questionTextField);
        }catch (NoSuchFieldException e){
            throw new ValidationException(ErrorType.FIELD_ERROR);
        }
    }

}
