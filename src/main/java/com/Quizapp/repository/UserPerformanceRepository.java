package com.Quizapp.repository;

//package com.quizapp.repository;

import com.Quizapp.model.UserPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPerformanceRepository extends JpaRepository<UserPerformance, String> {
    Optional<UserPerformance> findByUserId(String userId);
}
