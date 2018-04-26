package by.bsuir.talakh.core;

import by.bsuir.talakh.js_method.MethodDao;
import by.bsuir.talakh.js_object.JsObjectDao;
import by.bsuir.talakh.js_operator.OperatorDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private MethodDao methodDao = new MethodDao();
    private JsObjectDao jsObjectDao = new JsObjectDao();
    private OperatorDao operatorDao = new OperatorDao();

    public static DaoFactory getInstance() {
        return instance;
    }

    public MethodDao getMethodDao() {
        return methodDao;
    }

    public JsObjectDao getJsObjectDao() {
        return jsObjectDao;
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    private DaoFactory(){}

}
