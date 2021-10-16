package com.example.codecomp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.codecomp.dtos.Answer;
import com.example.codecomp.dtos.AnswerWithTaskTitle;
import com.example.codecomp.dtos.SolutionResponse;
import com.example.codecomp.properties.JdoodleProps;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final WebClient webClient;
    private final JdoodleProps jdoodleProps;
    private List<SolutionResponse> solutionResponses = new ArrayList<>();

    public SolutionResponse submitTask(AnswerWithTaskTitle answerWithTaskTitle) {
        SolutionResponse response = webClient.post()
                .uri(jdoodleProps.getCompilerUrl())
                .body(Mono.just(answerWithTaskTitle.getAnswer()), Answer.class)
                .retrieve()
                .bodyToMono(SolutionResponse.class)
                .block();

        Objects.requireNonNull(response).setTaskTitle(answerWithTaskTitle.getTaskTitle());
        solutionResponses.add(response);
        return response;
    }

    public List<SolutionResponse> getSubmitsAnswers() {
        return solutionResponses;
    }

}
