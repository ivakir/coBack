package com.example.codecomp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codecomp.dtos.AnswerWithTaskTitle;
import com.example.codecomp.dtos.SolutionResponse;
import com.example.codecomp.services.ChallengeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/challenge")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/submit-task")
    public SolutionResponse submitTask(@RequestBody AnswerWithTaskTitle answerWithTaskTitle) {
        return challengeService.submitTask(answerWithTaskTitle);
    }

    @GetMapping("/answers")
    public List<SolutionResponse> getSubmitsAnswers() {
        return challengeService.getSubmitsAnswers();
    }

}
