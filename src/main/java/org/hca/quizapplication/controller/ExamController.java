package org.hca.quizapplication.controller;

import lombok.RequiredArgsConstructor;
import org.hca.quizapplication.dto.request.QuestionCreateRequestDto;
import org.hca.quizapplication.dto.response.ExamResponseDto;
import org.hca.quizapplication.dto.response.QuestionCreateResponseDto;
import org.hca.quizapplication.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hca.quizapplication.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + EXAM)
@RequiredArgsConstructor
public class ExamController {
    private final QuestionService questionService;

    @GetMapping(GET_EXAM)
    public ResponseEntity<ExamResponseDto> getExam(@PathVariable Integer questionCount) {
        return ResponseEntity.ok(questionService.createExam(questionCount));
    }

}
