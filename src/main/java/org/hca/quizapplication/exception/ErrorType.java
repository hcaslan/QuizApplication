package org.hca.quizapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    NOT_FOUND(5000, "Not Found", HttpStatus.NOT_FOUND),
    DATABASE_ERROR(5001, "", HttpStatus.INTERNAL_SERVER_ERROR),
    FIELD_ERROR(5002, "", HttpStatus.INTERNAL_SERVER_ERROR),
    EMPTY_FIELD(5003, "This field can not be empty.", HttpStatus.BAD_REQUEST),
    MORE_THAN_ONE_CORRECT_ANSWER(5004, "There can not be more than one correct answer for a question", HttpStatus.BAD_REQUEST),
    NO_CORRECT_ANSWER(5005, "There must be one correct answer for a question", HttpStatus.BAD_REQUEST);

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;

}
