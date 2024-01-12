package TU_Java.Exam3;

import java.io.Serializable;

public class Question implements Serializable {

    public enum Answer {
        A, B, C, D, EMPTY
    }

    private int id;
    private String questionText;
    private Answer answer;

    public Question(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getId() {
        return id;
    }

    public Answer getAnswer() {
        return answer;
    }
}