
package com.Quizapp.dto;

import lombok.Data;
import java.util.Map;

@Data
public class QuestionDTO {
    private Long questionId;
    private String questionText;
    private Map<String, String> options;
}
