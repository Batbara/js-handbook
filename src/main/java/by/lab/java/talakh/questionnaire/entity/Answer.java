package by.lab.java.talakh.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    private int answerId;
    private String answerContent;

    public Answer() {
    }

    @Id
    @GeneratedValue
    @Column(name = "answerid")
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Column(name = "answer_content", length = 255)
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}
