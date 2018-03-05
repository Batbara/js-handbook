package by.lab.java.talakh.questionnaire.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "form_fill")
public class FormFill implements Serializable {
    private int formFillId;
    private Timestamp fillingDate;
    private List<Question> answeredQuestions;

    public FormFill() {
    }

    @Id
    @GeneratedValue
    @Column(name = "form_fill_id")
    public int getFormFillId() {
        return formFillId;
    }

    public void setFormFillId(int formFillId) {
        this.formFillId = formFillId;
    }

    @Column(name = "form_fill_date", nullable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    public Timestamp getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(Timestamp fillingDate) {
        this.fillingDate = fillingDate;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "form_fill_question_answers",
            joinColumns = {@JoinColumn(name = "form_fill_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_answer_id")})
    public List<Question> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<Question> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
