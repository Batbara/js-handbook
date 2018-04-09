package by.bsuir.talakh.controller;

import by.bsuir.talakh.domain.JsObjectAdapter;
import by.bsuir.talakh.domain.MethodAdapter;
import by.bsuir.talakh.domain.OperatorAdapter;
import org.apache.thrift.TException;

import java.rmi.RemoteException;
import java.util.List;

public interface Protocol {
    void addMethod(MethodAdapter methodAdapter) throws TException;

    List<MethodAdapter> takeMethodList(JsObjectAdapter jsObjectAdapter) throws TException;

    void updateMethod(MethodAdapter methodAdapter) throws TException;

    void deleteMethod(MethodAdapter methodAdapter) throws TException;

    MethodAdapter findMethodById(int id) throws TException;

    MethodAdapter findMethodByName(String name) throws TException;

    void addJsObject(JsObjectAdapter jsObjectAdapter) throws TException;

    List<JsObjectAdapter> takeJsObjectList() throws TException;

    void updateJsObject(JsObjectAdapter jsObjectAdapter) throws TException;

    void deleteJsObject(JsObjectAdapter jsObjectAdapter) throws TException;

    JsObjectAdapter findJsObjectById(int id) throws TException;

    JsObjectAdapter findJsObjectByName(String name) throws TException;

    void addOperator(OperatorAdapter operatorAdapter) throws TException;

    List<OperatorAdapter> takeOperatorList() throws TException;

    void updateOperator(OperatorAdapter operatorAdapter) throws TException;

    void deleteOperator(OperatorAdapter operatorAdapter) throws TException;

    OperatorAdapter findOperatorById(int id) throws TException;

    OperatorAdapter findOperatorByName(String name) throws TException;
}
