package org.hca.quizapplication.controller;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.request.QuestionCreateRequestDto;
import org.hca.quizapplication.dto.response.QuestionCreateResponseDto;
import org.hca.quizapplication.dto.response.QuestionResponseDto;
import org.hca.quizapplication.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hca.quizapplication.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + QUESTION)
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping(CREATE)
    public ResponseEntity<QuestionCreateResponseDto> createQuestion(@RequestBody QuestionCreateRequestDto requestDto) {
        return ResponseEntity.ok(questionService.createQuestion(requestDto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<QuestionResponseDto>> findAllQuestions() {
        return ResponseEntity.ok(questionService.findAllQuestions());
    }
    @GetMapping(FIND_BY_ID)
    public ResponseEntity<QuestionResponseDto> findQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findQuestionById(id));
    }

}
