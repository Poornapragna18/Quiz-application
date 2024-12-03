
package com.Quizapp.dto;

import lombok.Data;

@Data
public class PerformanceDTO {
    private int totalQuestions;
    private int correctQuestions;
    private double score;
    private boolean quizActive;
}