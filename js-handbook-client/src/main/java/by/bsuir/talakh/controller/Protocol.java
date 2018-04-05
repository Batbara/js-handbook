package by.bsuir.talakh.controller;

import by.bsuir.talakh.jsobject.JsObject;
import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.operator.Operator;
import org.apache.thrift.TException;

import java.util.List;

public interface Protocol {
    void addMethod(Method method) throws TException;

    List<Method> takeMethodList(JsObject jsObject) throws TException;

    void updateMethod(Method method) throws TException;

    void deleteMethod(Method method) throws TException;

    Method findMethodById(int id) throws TException;

    Method findMethodByName(String name) throws TException;

    void addJsObject(JsObject jsObject) throws TException;

    List<JsObject> takeJsObjectList() throws TException;

    void updateJsObject(JsObject jsObject) throws TException;

    void deleteJsObject(JsObject jsObject) throws TException;

    JsObject findJsObjectById(int id) throws TException;

    JsObject findJsObjectByName(String name) throws TException;

    void addOperator(Operator operator) throws TException;

    List<Operator> takeOperatorList() throws TException;

    void updateOperator(Operator operator) throws TException;

    void deleteOperator(Operator operator) throws TException;

    Operator findOperatorById(int id) throws TException;

    Operator findOperatorByName(String name) throws TException;
}
