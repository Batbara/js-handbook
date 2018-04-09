package by.bsuir.talakh.service;

import by.bsuir.talakh.entity.JsObject;
import by.bsuir.talakh.entity.Method;
import by.bsuir.talakh.entity.Operator;

import java.util.List;

public interface Protocol {
    void addMethod(Method method);

    List<Method> takeMethodList(JsObject jsObject);

    void updateMethod(Method method);

    void deleteMethod(Method method);

    Method findMethodById(int id);

    Method findMethodByName(String name);

    void addJsObject(JsObject jsObject);

    List<JsObject> takeJsObjectList();

    void updateJsObject(JsObject jsObject);

    void deleteJsObject(JsObject jsObject);

    JsObject findJsObjectById(int id);

    JsObject findJsObjectByName(String name);

    void addOperator(Operator operator);

    List<Operator> takeOperatorList();

    void updateOperator(Operator operator);

    void deleteOperator(Operator operator);

    Operator findOperatorById(int id);

    Operator findOperatorByName(String name);
}
