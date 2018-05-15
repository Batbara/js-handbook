package by.bsuir.talakh.controller;

import by.bsuir.talakh.domain.DomainAdapter;
import by.bsuir.talakh.domain.JsObjectAdapter;
import by.bsuir.talakh.domain.MethodAdapter;
import by.bsuir.talakh.domain.OperatorAdapter;
import by.bsuir.talakh.jsobject.JsObject;
import by.bsuir.talakh.jsobject.JsObjectService;
import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.method.MethodService;
import by.bsuir.talakh.operator.Operator;
import by.bsuir.talakh.operator.OperatorService;
import org.apache.thrift.TException;

import java.util.List;
import java.util.stream.Collectors;

public class RpcProtocol implements Protocol {
    private MethodService.Client methodService;
    private JsObjectService.Client jsObjectService;
    private OperatorService.Client operatorService;

    public RpcProtocol() {
    }

    public RpcProtocol(MethodService.Client methodService,
                       JsObjectService.Client jsObjectService,
                       OperatorService.Client operatorService) {
        this.methodService = methodService;
        this.jsObjectService = jsObjectService;
        this.operatorService = operatorService;
    }


    @Override
    public void addMethod(MethodAdapter methodAdapter) throws TException {
        Method method = DomainAdapter.getThriftMethod(methodAdapter);
        methodService.addMethod(method);
    }

    @Override
    public List<MethodAdapter> takeMethodList(JsObjectAdapter jsObject) throws TException {
        List<Method> methods = methodService.takeAll(jsObject.getId());
        return methods.stream()
                .map(DomainAdapter::getMethodAdapterFromThrift)
                .collect(Collectors.toList());
    }

    @Override
    public void updateMethod(MethodAdapter methodAdapter) throws TException {
        Method method = DomainAdapter.getThriftMethod(methodAdapter);
        methodService.updateMethod(method);
    }

    @Override
    public void deleteMethod(MethodAdapter methodAdapter) throws TException {
        Method method = DomainAdapter.getThriftMethod(methodAdapter);
        methodService.deleteMethod(method);
    }

    @Override
    public MethodAdapter findMethodById(int id) throws TException {
        Method method = methodService.findById(id);
        return DomainAdapter.getMethodAdapterFromThrift(method);
    }

    @Override
    public MethodAdapter findMethodByName(String name) throws TException {
        Method method = methodService.findByName(name);
        return DomainAdapter.getMethodAdapterFromThrift(method);
    }


    @Override
    public void addJsObject(JsObjectAdapter jsObjectAdapter) throws TException {
        JsObject jsObject = DomainAdapter.getThriftJsObject(jsObjectAdapter);
        jsObjectService.addObject(jsObject);
    }


    public List<JsObjectAdapter> takeJsObjectList() throws TException {
        List<JsObject> jsObjects = jsObjectService.takeAll();
        return jsObjects.stream()
                .map(DomainAdapter::getJsObjectAdapterFromThrift)
                .collect(Collectors.toList());
    }

    @Override
    public void updateJsObject(JsObjectAdapter jsObjectAdapter) throws TException {
        JsObject jsObject = DomainAdapter.getThriftJsObject(jsObjectAdapter);
        jsObjectService.updateObject(jsObject);
    }

    @Override
    public void deleteJsObject(JsObjectAdapter jsObjectAdapter) throws TException {
        JsObject jsObject = DomainAdapter.getThriftJsObject(jsObjectAdapter);
        jsObjectService.deleteObject(jsObject);
    }

    public JsObjectAdapter findJsObjectById(int id) throws TException {
        JsObject jsObject = jsObjectService.findById(id);
        return DomainAdapter.getJsObjectAdapterFromThrift(jsObject);
    }

    public JsObjectAdapter findJsObjectByName(String name) throws TException {
        JsObject jsObject = jsObjectService.findByName(name);
        return DomainAdapter.getJsObjectAdapterFromThrift(jsObject);
    }

    @Override
    public void addOperator(OperatorAdapter operatorAdapter) throws TException {
        Operator operator = DomainAdapter.getThriftOperator(operatorAdapter);
        operatorService.addOperator(operator);
    }


    public List<OperatorAdapter> takeOperatorList() throws TException {
        List<Operator> operators = operatorService.takeAll();
        return operators.stream()
                .map(DomainAdapter::getOperatorAdapterFromThrift)
                .collect(Collectors.toList());
    }

    @Override
    public void updateOperator(OperatorAdapter operatorAdapter) throws TException {
        Operator operator = DomainAdapter.getThriftOperator(operatorAdapter);
        operatorService.updateOperator(operator);
    }

    @Override
    public void deleteOperator(OperatorAdapter operatorAdapter) throws TException {
        Operator operator = DomainAdapter.getThriftOperator(operatorAdapter);
        operatorService.deleteOperator(operator);
    }

    public OperatorAdapter findOperatorById(int id) throws TException {
        Operator operator = operatorService.findById(id);
        return DomainAdapter.getOperatorAdapterFromThrift(operator);
    }

    public OperatorAdapter findOperatorByName(String name) throws TException {
        Operator operator = operatorService.findByName(name);
        return DomainAdapter.getOperatorAdapterFromThrift(operator);
    }
}
