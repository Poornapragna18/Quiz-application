// QuizController.java
package com.Quizapp.controller;

import com.Quizapp.service.QuizService;
import com.Quizapp.dto.QuestionDTO;
import com.Quizapp.dto.PerformanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<PerformanceDTO> getUserDashboard(@PathVariable String userId) {
        return ResponseEntity.ok(quizService.getUserPerformance(userId));
    }

    @PostMapping("/take/{userId}")
    public ResponseEntity<QuestionDTO> takeQuiz(@PathVariable String userId) {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }
    @PostMapping("/end/{userId}")
    public ResponseEntity<PerformanceDTO> endQuiz(@PathVariable String userId) {
        PerformanceDTO performanceDTO = quizService.endQuiz(userId);
        return ResponseEntity.ok(performanceDTO);
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<Boolean> submitAnswer(
            @PathVariable String userId,
            @RequestParam Long questionId,
            @RequestParam String selectedAnswer
    ) {
        return ResponseEntity.ok(quizService.submitAnswer(userId, questionId, selectedAnswer));
    }
}
