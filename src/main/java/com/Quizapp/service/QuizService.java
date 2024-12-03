package com.Quizapp.service;

import com.Quizapp.model.Question;
import com.Quizapp.model.UserPerformance;
import com.Quizapp.repository.QuestionRepository;
import com.Quizapp.repository.UserPerformanceRepository;
import com.Quizapp.dto.QuestionDTO;
import com.Quizapp.dto.PerformanceDTO;
import com.Quizapp.exception.QuizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserPerformanceRepository userPerformanceRepository;

    @Transactional
    public QuestionDTO getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new QuizException("No questions available");
        }

        Question randomQuestion = questions.get(new Random().nextInt(questions.size()));
        QuestionDTO dto = new QuestionDTO();
        dto.setQuestionId(randomQuestion.getId());
        dto.setQuestionText(randomQuestion.getText());
        dto.setOptions(Map.of(
                "A", randomQuestion.getOptionA(),
                "B", randomQuestion.getOptionB(),
                "C", randomQuestion.getOptionC(),
                "D", randomQuestion.getOptionD()
        ));

        return dto;
    }

    @Transactional
    public PerformanceDTO getUserPerformance(String userId) {
        UserPerformance performance = userPerformanceRepository.findByUserId(userId)
                .orElseGet(() -> {
                    UserPerformance newPerformance = new UserPerformance();
                    newPerformance.setUserId(userId);
                    return userPerformanceRepository.save(newPerformance);
                });

        PerformanceDTO dto = new PerformanceDTO();
        dto.setTotalQuestions(performance.getTotalQuestions());
        dto.setCorrectQuestions(performance.getCorrectQuestions());
        dto.setScore(performance.getScore());
        dto.setQuizActive(performance.isQuizActive());

        return dto;
    }

    @Transactional
    public boolean submitAnswer(String userId, Long questionId, String selectedAnswer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuizException("Invalid question ID"));

        UserPerformance performance = userPerformanceRepository.findByUserId(userId)
                .orElseThrow(() -> new QuizException("User performance not found"));

        performance.setTotalQuestions(performance.getTotalQuestions() + 1);
        performance.setQuizActive(true);

        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer);
        if (isCorrect) {
            performance.setCorrectQuestions(performance.getCorrectQuestions() + 1);
        }

        performance.setScore(calculateScore(performance));
        userPerformanceRepository.save(performance);

        return isCorrect;
    }
    @Transactional
    public PerformanceDTO endQuiz(String userId) {
        UserPerformance performance = userPerformanceRepository.findByUserId(userId)
                .orElseThrow(() -> new QuizException("User performance not found"));

        performance.setQuizActive(false);
        userPerformanceRepository.save(performance);

        PerformanceDTO dto = new PerformanceDTO();
        dto.setTotalQuestions(performance.getTotalQuestions());
        dto.setCorrectQuestions(performance.getCorrectQuestions());
        dto.setScore(performance.getScore());
        dto.setQuizActive(false);

        return dto;
    }

    private double calculateScore(UserPerformance performance) {
        return performance.getTotalQuestions() > 0
                ? (double) performance.getCorrectQuestions() / performance.getTotalQuestions() * 100
                : 0.0;
    }
}
