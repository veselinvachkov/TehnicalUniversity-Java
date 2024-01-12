package TU_Java.Exam3;

import java.io.*;
import java.util.*;

public class Quiz implements Serializable {
    private static int nextQuestionNumber = 0;
    private Student student;
    private List<Question> questionsList;
    private int currentQuestion;

    public Quiz() {
        this.questionsList = loadQuestions();
    }

    private List<Question> loadQuestions() {
        List<Question> loadedQuestions = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("questions.bin"))) {
            loadedQuestions = (List<Question>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Collections.shuffle(loadedQuestions);
        return loadedQuestions;
    }

    public boolean hasNext() {
        return currentQuestion < questionsList.size();
    }

    public String getCurrentQuestion() {
        return questionsList.get(currentQuestion).getQuestionText();
    }

    public void setAnswer(Question.Answer answer) {
        questionsList.get(currentQuestion).setAnswer(answer);
        moveToNextQuestion();
    }

    public boolean isPassed(Map<Integer, Question.Answer> clientAnswers) {
        int totalQuestions = questionsList.size();
        int correctPoints = 0;

        for (Map.Entry<Integer, Question.Answer> entry : clientAnswers.entrySet()) {
            Integer questionId = entry.getKey();
            Question.Answer clientAnswer = entry.getValue();

            for (Question question : questionsList) {
                if (question.getId() == questionId) {
                    Question.Answer correctAnswer = question.getAnswer();
                    if (correctAnswer == clientAnswer) {
                        correctPoints++;
                    }
                }
            }
        }

        return correctPoints > (totalQuestions / 2) + 1;
    }

    private void moveToNextQuestion() {
        if (hasNext()) {
            currentQuestion++;
            nextNumberCalc();
        } else {
            System.out.println("No more questions.");
        }
    }

    private static void nextNumberCalc() {
        nextQuestionNumber++;
    }
}