package by.bsuir.talakh.service;

import by.bsuir.talakh.dao.DaoFactory;
import by.bsuir.talakh.entity.JsObject;
import by.bsuir.talakh.entity.Method;
import by.bsuir.talakh.entity.Operator;

import javax.jws.WebService;
import java.util.List;

@WebService
public class JsHandbookService {

    public void deleteMethod(Method method) {
        DaoFactory.getInstance().getMethodDao().deleteMethod(method);
    }

    public Method findMethodById(int id) {
        return DaoFactory.getInstance().getMethodDao().findById(id);
    }


    public Method findMethodByName(String name) {
        return DaoFactory.getInstance().getMethodDao().findByName(name);
    }

    public void addJsObject(JsObject jsObject) {
        DaoFactory.getInstance().getJsObjectDao().addObject(jsObject);
    }


    public List<JsObject> takeJsObjectList() {
        return DaoFactory.getInstance().getJsObjectDao().takeAll();
    }


    public void updateJsObject(JsObject jsObject) {
        DaoFactory.getInstance().getJsObjectDao().updateObject(jsObject);
    }


    public void deleteJsObject(JsObject jsObject) {
        DaoFactory.getInstance().getJsObjectDao().deleteObject(jsObject);
    }


    public JsObject findJsObjectById(int id) {
        return DaoFactory.getInstance().getJsObjectDao().findById(id);
    }


    public JsObject findJsObjectByName(String name) {
        return DaoFactory.getInstance().getJsObjectDao().findByName(name);
    }


    public void addOperator(Operator operator) {
        DaoFactory.getInstance().getOperatorDao().addOperator(operator);
    }


    public List<Operator> takeOperatorList() {
        return DaoFactory.getInstance().getOperatorDao().takeAll();
    }


    public void updateOperator(Operator operator) {
        DaoFactory.getInstance().getOperatorDao().updateOperator(operator);
    }


    public void deleteOperator(Operator operator) {
        DaoFactory.getInstance().getOperatorDao().deleteOperator(operator);
    }


    public Operator findOperatorById(int id) {
        return DaoFactory.getInstance().getOperatorDao().findById(id);
    }


    public Operator findOperatorByName(String name) {
        return DaoFactory.getInstance().getOperatorDao().findByName(name);
    }

    public void updateMethod(Method method) {
        DaoFactory.getInstance().getMethodDao().updateMethod(method);
    }


    public void addMethod(Method method) {
        DaoFactory.getInstance().getMethodDao().addMethod(method);
    }


    public List<Method> takeMethodList(JsObject jsObject) {
        return DaoFactory.getInstance().getMethodDao().takeAll(jsObject.getId());
    }
}
