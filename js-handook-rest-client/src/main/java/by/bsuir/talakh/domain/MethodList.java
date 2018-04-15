package by.bsuir.talakh.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MethodList {
    @XmlElement(name = "method")
    private List<Method> methodList;

    public MethodList() {
        methodList = new ArrayList<>();

    }

    public MethodList(List<Method> methodList) {

        this.methodList = methodList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodList that = (MethodList) o;
        return Objects.equals(methodList, that.methodList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(methodList);
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    @Override
    public String toString() {
        return "MethodList{" +
                "methodList=" + methodList +
                '}';
    }
}
