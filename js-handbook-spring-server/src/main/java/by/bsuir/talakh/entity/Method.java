package by.bsuir.talakh.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="method")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Method.class)
public class Method implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="method_id", updatable = false)
    private Integer id;

    @Column(name = "method_name", updatable = false)
    private String name;

    @Column(name = "method_description")
    private String description;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "method_object_id", updatable = false)
    private JsObject methodObject;

    public Method() {
        methodObject = new JsObject();
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
