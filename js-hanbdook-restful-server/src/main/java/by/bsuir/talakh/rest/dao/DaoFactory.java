package by.bsuir.talakh.rest.dao;

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

    private DaoFactory() {
    }

}
