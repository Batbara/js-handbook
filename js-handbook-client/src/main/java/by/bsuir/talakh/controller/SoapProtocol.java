package by.bsuir.talakh.controller;

import by.bsuir.talakh.axis.service.JsHandbookServiceStub;
import by.bsuir.talakh.domain.DomainAdapter;
import by.bsuir.talakh.domain.JsObjectAdapter;
import by.bsuir.talakh.domain.MethodAdapter;
import by.bsuir.talakh.domain.OperatorAdapter;
import org.apache.axis2.AxisFault;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SoapProtocol implements Protocol {

    private final static String END_POINT = "http://localhost:8080/axis2/services/JsHandbookService?wsdl";

    private JsHandbookServiceStub serviceStub;

    public SoapProtocol() throws AxisFault {
        serviceStub = new JsHandbookServiceStub(END_POINT);
    }


    @Override
    public void addMethod(MethodAdapter methodAdapter) {
        JsHandbookServiceStub.Method method = DomainAdapter.getAxisMethod(methodAdapter);
        JsHandbookServiceStub.AddMethod addMethod = new JsHandbookServiceStub.AddMethod();
        addMethod.setMethod(method);

        try {
            serviceStub.addMethod(addMethod);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot add method", e);
        }

    }

    @Override
    public List<MethodAdapter> takeMethodList(JsObjectAdapter jsObjectAdapter) {

        JsHandbookServiceStub.JsObject jsObject = DomainAdapter.getAxisJsObject(jsObjectAdapter);
        JsHandbookServiceStub.TakeMethodList takeMethodListRequest = new JsHandbookServiceStub.TakeMethodList();
        takeMethodListRequest.setJsObject(jsObject);
        JsHandbookServiceStub.TakeMethodListResponse response = null;
        try {
            response = serviceStub.takeMethodList(takeMethodListRequest);
            JsHandbookServiceStub.Method[] methods = response.get_return();
            List<JsHandbookServiceStub.Method> methodList = (methods != null)
                    ? Arrays.asList(response.get_return())
                    : new ArrayList<>();
            return methodList.stream()
                    .map(DomainAdapter::getMethodAdapterFromAxis)
                    .collect(Collectors.toList());
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot take method list", e);
        }

    }

    @Override
    public void updateMethod(MethodAdapter methodAdapter) {
        JsHandbookServiceStub.Method method = DomainAdapter.getAxisMethod(methodAdapter);
        JsHandbookServiceStub.UpdateMethod updateMethodRequest = new JsHandbookServiceStub.UpdateMethod();
        updateMethodRequest.setMethod(method);

        try {
            serviceStub.updateMethod(updateMethodRequest);
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot update method", e);
        }
    }

    @Override
    public void deleteMethod(MethodAdapter methodAdapter) {
        JsHandbookServiceStub.Method method = DomainAdapter.getAxisMethod(methodAdapter);
        JsHandbookServiceStub.DeleteMethod deleteMethodRequest = new JsHandbookServiceStub.DeleteMethod();
        deleteMethodRequest.setMethod(method);

        try {
            serviceStub.deleteMethod(deleteMethodRequest);
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot delete method", e);
        }

    }

    public MethodAdapter findMethodById(int id) {

        JsHandbookServiceStub.FindMethodById findMethodByIdRequest = new JsHandbookServiceStub.FindMethodById();
        findMethodByIdRequest.setId(id);

        JsHandbookServiceStub.FindMethodByIdResponse response = null;
        try {
            response = serviceStub.findMethodById(findMethodByIdRequest);
            JsHandbookServiceStub.Method method = response.get_return();

            return DomainAdapter.getMethodAdapterFromAxis(method);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot find method by id", e);
        }


    }


    public MethodAdapter findMethodByName(String name) {
        JsHandbookServiceStub.FindMethodByName findMethodByNameRequest =
                new JsHandbookServiceStub.FindMethodByName();
        findMethodByNameRequest.setName(name);

        JsHandbookServiceStub.FindMethodByNameResponse response =
                null;
        try {
            response = serviceStub.findMethodByName(findMethodByNameRequest);
            JsHandbookServiceStub.Method method = response.get_return();
            return DomainAdapter.getMethodAdapterFromAxis(method);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot find method by name", e);
        }

    }

    @Override
    public void addJsObject(JsObjectAdapter jsObjectAdapter) {
        JsHandbookServiceStub.JsObject jsObject = DomainAdapter.getAxisJsObject(jsObjectAdapter);
        JsHandbookServiceStub.AddJsObject addJsObjectRequest = new JsHandbookServiceStub.AddJsObject();
        addJsObjectRequest.setJsObject(jsObject);

        try {
            serviceStub.addJsObject(addJsObjectRequest);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot add js object", e);
        }

    }

    public List<JsObjectAdapter> takeJsObjectList() {
        JsHandbookServiceStub.TakeJsObjectList takeJsObjectListRequest = new JsHandbookServiceStub.TakeJsObjectList();

        JsHandbookServiceStub.TakeJsObjectListResponse response =
                null;
        try {
            response = serviceStub.takeJsObjectList(takeJsObjectListRequest);
            List<JsHandbookServiceStub.JsObject> jsObjects = Arrays.asList(response.get_return());
            return jsObjects.stream()
                    .map(DomainAdapter::getJsObjectAdapterFromAxis)
                    .collect(Collectors.toList());
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot take js object list", e);
        }

    }

    @Override
    public void updateJsObject(JsObjectAdapter jsObjectAdapter) {
        JsHandbookServiceStub.JsObject jsObject = DomainAdapter.getAxisJsObject(jsObjectAdapter);
        JsHandbookServiceStub.UpdateJsObject updateJsObjectRequest = new JsHandbookServiceStub.UpdateJsObject();
        updateJsObjectRequest.setJsObject(jsObject);

        try {
            serviceStub.updateJsObject(updateJsObjectRequest);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot update js object", e);
        }
    }

    @Override
    public void deleteJsObject(JsObjectAdapter jsObjectAdapter) {

        JsHandbookServiceStub.JsObject jsObject = DomainAdapter.getAxisJsObject(jsObjectAdapter);
        JsHandbookServiceStub.DeleteJsObject deleteJsObjectRequest = new JsHandbookServiceStub.DeleteJsObject();
        deleteJsObjectRequest.setJsObject(jsObject);

        try {
            serviceStub.deleteJsObject(deleteJsObjectRequest);
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot delete js object", e);
        }

    }


    public JsObjectAdapter findJsObjectById(int id) {
        JsHandbookServiceStub.FindJsObjectById findJsObjectByIdRequest = new JsHandbookServiceStub.FindJsObjectById();
        findJsObjectByIdRequest.setId(id);

        JsHandbookServiceStub.FindJsObjectByIdResponse response =
                null;
        try {
            response = serviceStub.findJsObjectById(findJsObjectByIdRequest);

            JsHandbookServiceStub.JsObject jsObject = response.get_return();
            return DomainAdapter.getJsObjectAdapterFromAxis(jsObject);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot find js object by id", e);
        }
    }


    public JsObjectAdapter findJsObjectByName(String name) {
        JsHandbookServiceStub.FindJsObjectByName findJsObjectByNameRequest =
                new JsHandbookServiceStub.FindJsObjectByName();
        findJsObjectByNameRequest.setName(name);

        JsHandbookServiceStub.FindJsObjectByNameResponse response =
                null;
        try {
            response = serviceStub.findJsObjectByName(findJsObjectByNameRequest);
            JsHandbookServiceStub.JsObject jsObject = response.get_return();
            return DomainAdapter.getJsObjectAdapterFromAxis(jsObject);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot find js object by name", e);
        }

    }

    @Override
    public void addOperator(OperatorAdapter operatorAdapter) {
        JsHandbookServiceStub.Operator operator = DomainAdapter.getAxisOperator(operatorAdapter);
        JsHandbookServiceStub.AddOperator addOperatorRequest = new JsHandbookServiceStub.AddOperator();
        addOperatorRequest.setOperator(operator);
        try {
            serviceStub.addOperator(addOperatorRequest);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot add operator", e);
        }

    }


    public List<OperatorAdapter> takeOperatorList() {
        JsHandbookServiceStub.TakeOperatorList takeOperatorListRequest = new JsHandbookServiceStub.TakeOperatorList();

        JsHandbookServiceStub.TakeOperatorListResponse response =
                null;
        try {
            response = serviceStub.takeOperatorList(takeOperatorListRequest);
            List<JsHandbookServiceStub.Operator> operators = Arrays.asList(response.get_return());
            return operators.stream()
                    .map(DomainAdapter::getOperatorAdapterFromAxis)
                    .collect(Collectors.toList());
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot take operator list", e);
        }

    }

    @Override
    public void updateOperator(OperatorAdapter operatorAdapter) {
        JsHandbookServiceStub.Operator operator = DomainAdapter.getAxisOperator(operatorAdapter);
        JsHandbookServiceStub.UpdateOperator updateOperatorRequest = new JsHandbookServiceStub.UpdateOperator();
        updateOperatorRequest.setOperator(operator);
        try {
            serviceStub.updateOperator(updateOperatorRequest);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot update operator", e);
        }
    }

    @Override
    public void deleteOperator(OperatorAdapter operatorAdapter) {

        JsHandbookServiceStub.Operator operator = DomainAdapter.getAxisOperator(operatorAdapter);
        JsHandbookServiceStub.DeleteOperator deleteOperatorRequest = new JsHandbookServiceStub.DeleteOperator();
        deleteOperatorRequest.setOperator(operator);
        try {
            serviceStub.deleteOperator(deleteOperatorRequest);
        } catch (RemoteException e) {
            throw new ProtocolException("Cannot delete operator", e);
        }

    }


    public OperatorAdapter findOperatorById(int id) {
        JsHandbookServiceStub.FindOperatorById findOperatorByIdRequest = new JsHandbookServiceStub.FindOperatorById();
        findOperatorByIdRequest.setId(id);

        JsHandbookServiceStub.FindOperatorByIdResponse response =
                null;
        try {
            response = serviceStub.findOperatorById(findOperatorByIdRequest);
            JsHandbookServiceStub.Operator operator = response.get_return();
            return DomainAdapter.getOperatorAdapterFromAxis(operator);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot find operator by id", e);
        }

    }


    public OperatorAdapter findOperatorByName(String name) {
        JsHandbookServiceStub.FindOperatorByName findOperatorByNameRequest =
                new JsHandbookServiceStub.FindOperatorByName();
        findOperatorByNameRequest.setName(name);
        JsHandbookServiceStub.FindOperatorByNameResponse response =
                null;
        try {
            response = serviceStub.findOperatorByName(findOperatorByNameRequest);
            JsHandbookServiceStub.Operator operator = response.get_return();
            return DomainAdapter.getOperatorAdapterFromAxis(operator);
        } catch (RemoteException e) {

            throw new ProtocolException("Cannot find operator by name", e);
        }

    }
}
