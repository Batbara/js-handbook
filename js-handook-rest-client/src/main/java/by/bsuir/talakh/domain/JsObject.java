package by.bsuir.talakh.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "jsObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class JsObject implements Serializable {
    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    private MethodList methodList;
    public JsObject(){
        methodList = new MethodList();
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

    public MethodList getMethodList() {
        return methodList;
    }

    public void setMethodList(MethodList methodList) {
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
