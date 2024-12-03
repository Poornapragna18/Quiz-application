Project Name: Quiz Application

Description:
The Quiz Application is a simple web-based quiz platform built using Spring Boot and H2 Database. The application allows users to take a quiz, track their performance, and receive feedback on their progress. It features a set of multiple-choice questions, stores user performance data, and calculates a score based on the user's answers.

Key Features:
Randomized Questions: The system fetches random questions from a predefined set stored in a database.
User Performance Tracking: It tracks user performance, including the total number of questions answered, the number of correct answers, and the score achieved.
Dynamic Quiz Flow: Users can take a quiz, submit answers, and receive immediate feedback on their performance.
Quiz Completion: Users can end the quiz at any point, and their results are calculated and displayed.
Database Integration: Uses H2 Database for storing questions and user performance data. Database initialization is handled with SQL scripts.
Technologies Used:
Backend: Spring Boot
Database: H2 (in-memory database)
Java: Version 17
Frontend: The application doesn’t include a frontend, as it is API-driven. It can be integrated with any frontend framework.
Testing: Includes unit and integration tests to ensure the application works as expected.
Endpoints:
GET /quiz/dashboard/{userId}: Fetches user performance details.
POST /quiz/take/{userId}: Fetches a random question for the user.
POST /quiz/submit/{userId}: Submits an answer and updates the user's performance.
POST /quiz/end/{userId}: Ends the quiz and returns the user's final score.
Installation:
Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/quiz-application.git
Navigate to the project directory:
bash
Copy code
cd quiz-application
Build and run the application using Maven:
bash
Copy code
mvn spring-boot:run
Usage:
Once the application is running, you can interact with the endpoints using curl, Postman, or integrate it with any frontend. The H2 console can be accessed via http://localhost:8080/h2-console to monitor and interact with the database.

Future Improvements:
Integrate a frontend UI for a better user experience.
Add user authentication and role management for personalized quizzes.
Implement a more complex scoring system or timer functionality.
