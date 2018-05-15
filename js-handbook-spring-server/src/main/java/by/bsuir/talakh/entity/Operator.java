package by.bsuir.talakh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="operator")
public class Operator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "operator_id", updatable = false)
    private Integer id;
    @Column(name = "operator_name", updatable = false)
    private String name;
    @Column(name = "operator_description")
    private String description;
    @Column(name = "operator_symbol", updatable = false)
    private String operatorSymbol;

    public Operator() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return id.equals(operator.id) &&
                Objects.equals(name, operator.name) &&
                Objects.equals(description, operator.description) &&
                Objects.equals(operatorSymbol, operator.operatorSymbol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, operatorSymbol);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", operatorSymbol='" + operatorSymbol + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }

    public void setOperatorSymbol(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }
}
