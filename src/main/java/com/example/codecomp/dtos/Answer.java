package com.example.codecomp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private String clientId;
    private String clientSecret;
    private String language;
    private String script;
    private String stdin;
    private String args;
}
