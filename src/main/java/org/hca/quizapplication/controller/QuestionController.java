package org.hca.quizapplication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.request.QuestionCreateRequestDto;
import org.hca.quizapplication.dto.response.QuestionCreateResponseDto;
import org.hca.quizapplication.entity.Question;
import org.hca.quizapplication.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

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
}
