package org.hca.quizapplication.util;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.exception.ErrorType;
import org.hca.quizapplication.exception.ValidationException;

import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.util.List;
/**
 * These classes provide a structured approach to validate entities and perform custom validation checks specific to the project's requirements
 */
@RequiredArgsConstructor
public class BusinessRulesManager implements IBusinessRules{


    public void checkIfNull(String value) {
        if(value == null) {
            throw new ValidationException(ErrorType.EMPTY_FIELD);
        }
    }

    @Override
    public void checkIfNull(Long value) {
        if(value == null) {
            throw new ValidationException(ErrorType.EMPTY_FIELD);
        }
    }

    @Override
    public void checkIfListValid(List<?> list) {
        if(list == null) throw new ValidationException(ErrorType.EMPTY_FIELD);
        if (list.isEmpty()) throw new ValidationException(ErrorType.EMPTY_FIELD);
    }

    private int getMaxLength(Field field) {
        Size maxLength = field.getAnnotation(Size.class);
        if (maxLength != null) {
            return maxLength.max();
        }
        return Integer.MAX_VALUE;
    }
    private static int getMinLength(Field field) {
        Size minLength = field.getAnnotation(Size.class);
        if (minLength != null) {
            return minLength.min();
        }
        return Integer.MIN_VALUE;
    }

    private void validateFieldLength(String value, String fieldName, int maxLength, int minLength) {
        if (value != null) {
            if (maxLength != -1 && value.length() > maxLength) {
                throw new ValidationException(ErrorType.DATABASE_ERROR, fieldName + " exceeds maximum length of " + maxLength + " characters.");
            }
            if (minLength != -1 && value.length() < minLength) {
                throw new ValidationException(ErrorType.DATABASE_ERROR, fieldName + " must be at least " + minLength + " characters long.");
            }
        } else {
            throw new ValidationException(ErrorType.EMPTY_FIELD, fieldName);
        }
    }

    public void validateFieldLength(String value, Field field) {
        int maxLength = getMaxLength(field);
        int minLength = getMinLength(field);
        validateFieldLength(value, field.getName(), maxLength, minLength);
    }
}
