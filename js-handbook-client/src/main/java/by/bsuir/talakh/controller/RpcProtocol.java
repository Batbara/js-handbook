package by.bsuir.talakh.controller;

import by.bsuir.talakh.jsobject.JsObject;
import by.bsuir.talakh.jsobject.JsObjectService;
import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.method.MethodService;
import by.bsuir.talakh.operator.Operator;
import by.bsuir.talakh.operator.OperatorService;
import org.apache.thrift.TException;

import java.util.List;

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

    public void addMethod(Method method) throws TException {
        methodService.addMethod(method);
    }

    public List<Method> takeMethodList(JsObject jsObject) throws TException {
        return methodService.takeAll(jsObject.getId());
    }

    public void updateMethod(Method method) throws TException {
        methodService.updateMethod(method);
    }

    public void deleteMethod(Method method) throws TException {
        methodService.deleteMethod(method);
    }

    public Method findMethodById(int id) throws TException {
        return methodService.findById(id);
    }

    public Method findMethodByName(String name) throws TException {
        return methodService.findByName(name);
    }

    public void addJsObject(JsObject jsObject) throws TException {
        jsObjectService.addObject(jsObject);
    }

    public List<JsObject> takeJsObjectList() throws TException {
        return jsObjectService.takeAll();
    }

    public void updateJsObject(JsObject jsObject) throws TException {
        jsObjectService.updateObject(jsObject);
    }

    public void deleteJsObject(JsObject jsObject) throws TException {
        jsObjectService.deleteObject(jsObject);
    }

    public JsObject findJsObjectById(int id) throws TException {
        return jsObjectService.findById(id);
    }

    public JsObject findJsObjectByName(String name) throws TException {
        return jsObjectService.findByName(name);
    }

    public void addOperator(Operator operator) throws TException {
        operatorService.addOperator(operator);
    }

    public List<Operator> takeOperatorList() throws TException {
        return operatorService.takeAll();
    }

    public void updateOperator(Operator operator) throws TException {
        operatorService.updateOperator(operator);
    }

    public void deleteOperator(Operator operator) throws TException {
        operatorService.deleteOperator(operator);
    }

    public Operator findOperatorById(int id) throws TException {
        return operatorService.findById(id);
    }

    public Operator findOperatorByName(String name) throws TException {
        return operatorService.findByName(name);
    }
}
