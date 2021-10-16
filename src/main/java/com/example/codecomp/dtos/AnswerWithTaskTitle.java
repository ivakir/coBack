package com.example.codecomp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerWithTaskTitle {
    private String taskTitle;
    private Answer answer;
}
