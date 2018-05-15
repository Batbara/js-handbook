package by.bsuir.talakh.rest.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OperatorList {
    @XmlElement(name = "operator")
    private List<Operator> operatorList;

    public OperatorList() {
    }

    public OperatorList(List<Operator> operatorList) {
        this.operatorList = operatorList;
    }

    public List<Operator> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(List<Operator> operatorList) {
        this.operatorList = operatorList;
    }
}
