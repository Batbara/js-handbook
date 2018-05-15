package by.bsuir.talakh.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name = "method")
@XmlAccessorType(XmlAccessType.FIELD)
public class Method implements Serializable {
    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    private JsObject methodObject;

    public Method() {
        methodObject = new JsObject();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Method method = (Method) o;
        return id == method.id &&
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
