package by.bsuir.talakh.entity;

import java.io.Serializable;
import java.util.Objects;

public class Method implements Serializable {
    private Integer id;

    private String name;

    private String description;
    private JsObject methodObject;

    public Method() {
        id=0;
        methodObject = new JsObject();
    }

    public Method(int id){
        super();
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Method method = (Method) o;
        return Objects.equals(id, method.id)  &&
        Objects.equals(name, method.name) &&
                Objects.equals(description, method.description) &&
                Objects.equals(methodObject, method.methodObject);
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

    public JsObject getMethodObject() {
        return methodObject;
    }

    public void setMethodObject(JsObject methodObject) {
        this.methodObject = methodObject;
    }

}
