package by.bsuir.talakh.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsObject implements Serializable {
    private Integer id;
    private String name;
    private String description;

    private List<Method> methodList;

    public JsObject() {
        id = 0;
        methodList = new ArrayList<>();
    }
    public JsObject(int id){
        super();
        this.id = id;
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

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsObject jsObject = (JsObject) o;
        return id == jsObject.id &&
                Objects.equals(name, jsObject.name) &&
                Objects.equals(description, jsObject.description) &&
                Objects.equals(methodList, jsObject.methodList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, methodList);
    }
}
