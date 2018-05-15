package by.bsuir.talakh.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "object")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = JsObject.class)
public class JsObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "object_id", updatable = false)
    private Integer id;
    @Column(name = "object_name", updatable = false)
    private String name;
    @Column(name = "object_descr")
    private String description;

    @OneToMany(mappedBy = "methodObject")
    private List<Method> methodList;

    public JsObject() {
        methodList = new ArrayList<>();
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
