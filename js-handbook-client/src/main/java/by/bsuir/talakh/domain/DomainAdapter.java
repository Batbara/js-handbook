package by.bsuir.talakh.domain;

public final class DomainAdapter {
    private DomainAdapter() {
    }

    public static by.bsuir.talakh.jsobject.JsObject getThriftJsObject(JsObjectAdapter jsObjectAdapter) {
        by.bsuir.talakh.jsobject.JsObject jsObject = new by.bsuir.talakh.jsobject.JsObject();
        jsObject.setDescription(jsObjectAdapter.getDescription());
        jsObject.setName(jsObjectAdapter.getName());
        jsObject.setId(jsObjectAdapter.getId());
        return jsObject;
    }

    public static JsObjectAdapter getJsObjectAdapterFromThrift(by.bsuir.talakh.jsobject.JsObject jsObject) {
        JsObjectAdapter jsObjectAdapter = new JsObjectAdapter();
        jsObjectAdapter.setDescription(jsObject.getDescription());
        jsObjectAdapter.setId(jsObject.getId());
        jsObjectAdapter.setName(jsObject.getName());
        return jsObjectAdapter;
    }

    public static by.bsuir.talakh.axis.service.JsHandbookServiceStub.JsObject getAxisJsObject(JsObjectAdapter jsObjectAdapter) {
        by.bsuir.talakh.axis.service.JsHandbookServiceStub.JsObject jsObject = new by.bsuir.talakh.axis.service.JsHandbookServiceStub.JsObject();
        jsObject.setDescription(jsObjectAdapter.getDescription());
        jsObject.setName(jsObjectAdapter.getName());
        jsObject.setId(jsObjectAdapter.getId());
        return jsObject;
    }

    public static JsObjectAdapter getJsObjectAdapterFromAxis(by.bsuir.talakh.axis.service.JsHandbookServiceStub.JsObject jsObject) {
        JsObjectAdapter jsObjectAdapter = new JsObjectAdapter();
        jsObjectAdapter.setDescription(jsObject.getDescription());
        jsObjectAdapter.setId(jsObject.getId());
        jsObjectAdapter.setName(jsObject.getName());
        return jsObjectAdapter;
    }

    public static by.bsuir.talakh.method.Method getThriftMethod(MethodAdapter methodAdapter) {
        by.bsuir.talakh.method.Method method = new by.bsuir.talakh.method.Method();
        method.setDescription(methodAdapter.getDescription());
        method.setName(methodAdapter.getName());
        method.setId(methodAdapter.getId());
        method.setObjectName(methodAdapter.getMethodObject().getName());
        method.setObjectId(methodAdapter.getMethodObject().getId());
        return method;
    }

    public static MethodAdapter getMethodAdapterFromThrift(by.bsuir.talakh.method.Method method) {
        MethodAdapter methodAdapter = new MethodAdapter();
        methodAdapter.setDescription(method.getDescription());
        methodAdapter.setId(method.getId());
        methodAdapter.setName(method.getName());

        JsObjectAdapter jsObjectAdapter = new JsObjectAdapter();
        jsObjectAdapter.setName(method.getObjectName());
        jsObjectAdapter.setId(method.getId());
        methodAdapter.setMethodObject(jsObjectAdapter);
        return methodAdapter;
    }

    public static by.bsuir.talakh.axis.service.JsHandbookServiceStub.Method getAxisMethod(MethodAdapter methodAdapter) {
        by.bsuir.talakh.axis.service.JsHandbookServiceStub.Method method =
                new by.bsuir.talakh.axis.service.JsHandbookServiceStub.Method();
        method.setDescription(methodAdapter.getDescription());
        method.setName(methodAdapter.getName());
        method.setId(methodAdapter.getId());
        by.bsuir.talakh.axis.service.JsHandbookServiceStub.JsObject jsObject = getAxisJsObject(methodAdapter.getMethodObject());
        method.setMethodObject(jsObject);
        return method;
    }

    public static MethodAdapter getMethodAdapterFromAxis(by.bsuir.talakh.axis.service.JsHandbookServiceStub.Method method) {
        MethodAdapter methodAdapter = new MethodAdapter();
        methodAdapter.setDescription(method.getDescription());
        methodAdapter.setId(method.getId());
        methodAdapter.setName(method.getName());

        JsObjectAdapter jsObjectAdapter = getJsObjectAdapterFromAxis(method.getMethodObject());
        methodAdapter.setMethodObject(jsObjectAdapter);
        return methodAdapter;
    }

    public static by.bsuir.talakh.axis.service.JsHandbookServiceStub.Operator getAxisOperator(OperatorAdapter operatorAdapter) {
        by.bsuir.talakh.axis.service.JsHandbookServiceStub.Operator operator = new by.bsuir.talakh.axis.service.JsHandbookServiceStub.Operator();
        operator.setDescription(operatorAdapter.getDescription());
        operator.setId(operatorAdapter.getId());
        operator.setName(operatorAdapter.getName());
        operator.setOperatorSymbol(operatorAdapter.getOperatorSymbol());
        return operator;
    }

    public static OperatorAdapter getOperatorAdapterFromAxis(by.bsuir.talakh.axis.service.JsHandbookServiceStub.Operator operator) {
        OperatorAdapter operatorAdapter = new OperatorAdapter();
        operatorAdapter.setDescription(operator.getDescription());
        operatorAdapter.setId(operator.getId());
        operatorAdapter.setName(operator.getName());
        operatorAdapter.setOperatorSymbol(operator.getOperatorSymbol());
        return operatorAdapter;
    }

    public static by.bsuir.talakh.operator.Operator getThriftOperator(OperatorAdapter operatorAdapter) {
        by.bsuir.talakh.operator.Operator operator = new by.bsuir.talakh.operator.Operator();
        operator.setDescription(operatorAdapter.getDescription());
        operator.setId(operatorAdapter.getId());
        operator.setName(operatorAdapter.getName());
        operator.setOperatorSymbol(operatorAdapter.getOperatorSymbol());
        return operator;
    }

    public static OperatorAdapter getOperatorAdapterFromThrift(by.bsuir.talakh.operator.Operator operator) {
        OperatorAdapter operatorAdapter = new OperatorAdapter();
        operatorAdapter.setDescription(operator.getDescription());
        operatorAdapter.setId(operator.getId());
        operatorAdapter.setName(operator.getName());
        operatorAdapter.setOperatorSymbol(operator.getOperatorSymbol());
        return operatorAdapter;
    }
}
