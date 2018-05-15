package by.bsuir.talakh.domain;

import java.io.Serializable;
import java.util.Objects;

public class MethodAdapter implements Serializable {
    private int id;
    private String name;
    private String description;
    private JsObjectAdapter methodObject;

    public MethodAdapter() {
    }

    public MethodAdapter(MethodAdapter methodAdapter) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodAdapter methodAdapter = (MethodAdapter) o;
        return id == methodAdapter.id &&
                Objects.equals(name, methodAdapter.name) &&
                Objects.equals(description, methodAdapter.description) &&
                Objects.equals(methodObject, methodAdapter.methodObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, methodObject);
    }

    @Override
    public String toString() {
        return "Method{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", methodObjectName=" + methodObject.getName() +
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

    public JsObjectAdapter getMethodObject() {
        return methodObject;
    }

    public void setMethodObject(JsObjectAdapter methodObject) {
        this.methodObject = methodObject;
    }
}
