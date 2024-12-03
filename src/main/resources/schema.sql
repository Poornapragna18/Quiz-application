-- Create Questions Table
CREATE TABLE IF NOT EXISTS questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(500) NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    correct_answer VARCHAR(10) NOT NULL
);

-- Create User Performance Table
CREATE TABLE IF NOT EXISTS user_performance (
    user_id VARCHAR(100) PRIMARY KEY,
    total_questions INTEGER DEFAULT 0,
    correct_questions INTEGER DEFAULT 0,
    score DOUBLE DEFAULT 0.0,
    quiz_active BOOLEAN DEFAULT FALSE
);