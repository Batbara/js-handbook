package by.bsuir.talakh.domain;

import java.io.Serializable;
import java.util.Objects;

public class OperatorAdapter implements Serializable {
    private int id;
    private String name;
    private String description;
    private String operatorSymbol;
    public OperatorAdapter(){}

    public OperatorAdapter(OperatorAdapter operatorAdapter) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorAdapter operatorAdapter = (OperatorAdapter) o;
        return id == operatorAdapter.id &&
                Objects.equals(name, operatorAdapter.name) &&
                Objects.equals(description, operatorAdapter.description) &&
                Objects.equals(operatorSymbol, operatorAdapter.operatorSymbol);
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
