package com.example.codecomp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolutionResponse {
    private String output;
    private int statusCode;
    private String memory;
    private String cpuTime;
    private String taskTitle;
}
