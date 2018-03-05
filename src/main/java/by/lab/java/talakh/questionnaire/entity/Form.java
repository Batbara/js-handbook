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
@Table (name = "form")
public class Form implements Serializable{
    private int formId;
    private Timestamp creationDate;
    private String formTitle;
    private String formDescription;
    private List<Question> questionList;

    public Form(){}

    @Id
    @GeneratedValue
    @Column(name = "form_id")
    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    @Column(name = "form_title", length = 65, nullable = false)
    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    @Column(name = "form_description", length = 255)
    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

    @Column(name = "form_creation_date", nullable = false,
            columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "form_questions",
            joinColumns = { @JoinColumn(name = "form_id") },
            inverseJoinColumns = { @JoinColumn(name = "question_id") })
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
