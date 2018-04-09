package by.bsuir.talakh.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class
JsObjectAdapter implements Serializable {
    private int id;
    private String name;
    private String description;
    private List<MethodAdapter> methodAdapterList;
    public JsObjectAdapter(){}

    public JsObjectAdapter(JsObjectAdapter jsObjectAdapter) {

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

    public List<MethodAdapter> getMethodAdapterList() {
        return methodAdapterList;
    }

    public void setMethodAdapterList(List<MethodAdapter> methodAdapterList) {
        this.methodAdapterList = methodAdapterList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsObjectAdapter jsObjectAdapter = (JsObjectAdapter) o;
        return id == jsObjectAdapter.id &&
                Objects.equals(name, jsObjectAdapter.name) &&
                Objects.equals(description, jsObjectAdapter.description) &&
                Objects.equals(methodAdapterList, jsObjectAdapter.methodAdapterList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, methodAdapterList);
    }
}
