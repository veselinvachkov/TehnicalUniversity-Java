package TU_Java.Exam3;
import java.io.*;
import java.net.*;
import java.util.*;

public class QuizServer {
    private static final int PORT = 3033;
    private static Map<Integer, Question.Answer> clientAnswers = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Quiz Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new QuizClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class QuizClientHandler extends Thread {
        private Socket clientSocket;
        private Scanner in;
        private PrintStream out;

        public QuizClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                in = new Scanner(clientSocket.getInputStream());
                out = new PrintStream(clientSocket.getOutputStream());

                out.println("Hello! Welcome to the Quiz Server.");
                out.println("Enter your EGN:");
                int egn = in.nextInt();
                out.println("Enter your Faculty Number:");
                int facultyNumber = in.nextInt();

                Student student = new Student(Integer.toString(egn), Integer.toString(facultyNumber));
                Quiz quiz = new Quiz();
                handleQuiz(quiz);

                clientSocket.close();
            } catch (IOException | StudentException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        }

        private void handleQuiz(Quiz quiz) {
            while (quiz.hasNext()) {
                out.println("Question: " + quiz.getCurrentQuestion());
                out.println("Options: A, B, C, D, EMPTY");
                out.println("Enter your answer:");
                String answer = in.nextLine().toUpperCase();
                Question.Answer answerEnum = Question.Answer.valueOf(answer);

                quiz.setAnswer(answerEnum);
            }

            out.println("Quiz completed!");
            out.println("Enter your answers in the format: id answer (e.g., 1 A)");
            fillClientAnswers(quiz);
            boolean passed = quiz.isPassed(clientAnswers);

            if (passed) {
                out.println("Congratulations! You passed the quiz.");
            } else {
                out.println("Sorry! You did not pass the quiz.");
            }
        }

        private void fillClientAnswers(Quiz quiz) {
            while (quiz.hasNext()) {
                out.println("Give id and answer");
                int id = in.nextInt();
                String answer = in.next();
                clientAnswers.put(id, Question.Answer.valueOf(answer.toUpperCase()));
            }
        }
    }
}
