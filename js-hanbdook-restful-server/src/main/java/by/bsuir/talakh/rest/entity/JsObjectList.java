package by.bsuir.talakh.rest.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JsObjectList {
    @XmlElement(name = "jsObject")
    private List<JsObject> jsObjectList;

    public JsObjectList() {
    }

    public JsObjectList(List<JsObject> jsObjectList) {
        this.jsObjectList = jsObjectList;
    }

    public List<JsObject> getJsObjectList() {
        return jsObjectList;
    }

    public void setJsObjectList(List<JsObject> jsObjectList) {
        this.jsObjectList = jsObjectList;
    }
}
