package org.hca.quizapplication.rules;

import org.hca.quizapplication.entity.Answer;
import org.hca.quizapplication.entity.Question;
import org.hca.quizapplication.exception.ErrorType;
import org.hca.quizapplication.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class AnswerBusinessRules extends BusinessRulesManager{
    public void validateAnswerFieldLengths(Answer answer){
        try{
            Field answerTextField = answer.getClass().getDeclaredField("answerText");
            validateFieldLength(answer.getAnswerText(),answerTextField);
        }catch (NoSuchFieldException e){
            throw new ValidationException(ErrorType.FIELD_ERROR);
        }
    }

    public void validateCorrectAnswerLogic(List<Answer> answers){
        int flag = 1;
        for ( Answer answer : answers ) {
            if(answer.isCorrectAnswer())  flag -=1 ;
        }
        if(flag == 0 ){
            //do nothing
        }else if(flag == 1){
            throw new ValidationException(ErrorType.NO_CORRECT_ANSWER);
        }else{
            throw new ValidationException(ErrorType.MORE_THAN_ONE_CORRECT_ANSWER);
        }
    }

}