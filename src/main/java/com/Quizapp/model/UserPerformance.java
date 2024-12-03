package com.Quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_performance")
public class UserPerformance {
    @Id
    private String userId;

    @Column(name = "total_questions")
    private int totalQuestions = 0;

    @Column(name = "correct_questions")
    private int correctQuestions = 0;

    @Column(name = "score")
    private double score = 0.0;

    @Column(name = "quiz_active")
    private boolean quizActive = false;
}
