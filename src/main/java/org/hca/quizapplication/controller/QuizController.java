package org.hca.quizapplication.controller;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.response.QuizResponseDto;
import org.hca.quizapplication.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.hca.quizapplication.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + QUIZ)
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping(GET_QUIZ)
    public ResponseEntity<QuizResponseDto> createQuiz(@PathVariable Integer questionCount) {
        return ResponseEntity.ok(quizService.createQuiz(questionCount));
    }

}
