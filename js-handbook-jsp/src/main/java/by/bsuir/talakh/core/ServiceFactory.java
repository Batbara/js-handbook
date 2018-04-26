package by.bsuir.talakh.core;

import by.bsuir.talakh.js_object.JsObjectService;
import by.bsuir.talakh.js_method.MethodService;
import by.bsuir.talakh.js_operator.OperatorService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private MethodService methodService = new MethodService();
    private JsObjectService jsObjectService = new JsObjectService();
    private OperatorService operatorService = new OperatorService();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MethodService getMethodService() {
        return methodService;
    }

    public JsObjectService getJsObjectService() {
        return jsObjectService;
    }

    public OperatorService getOperatorService() {
        return operatorService;
    }

    private ServiceFactory(){}
}
