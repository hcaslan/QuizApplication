package org.hca.quizapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hca.quizapplication.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + ANSWER)
@RequiredArgsConstructor
public class AnswerController {
}
