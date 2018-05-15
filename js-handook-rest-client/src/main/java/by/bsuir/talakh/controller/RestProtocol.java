package by.bsuir.talakh.controller;

import by.bsuir.talakh.domain.JsObject;
import by.bsuir.talakh.domain.JsObjectList;
import by.bsuir.talakh.domain.Method;
import by.bsuir.talakh.domain.MethodList;
import by.bsuir.talakh.domain.Operator;
import by.bsuir.talakh.domain.OperatorList;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class RestProtocol implements Protocol {
    private static final String TARGET = "http://localhost:8080/rest";
    private static final Logger LOGGER = Logger.getLogger(RestProtocol.class);

    @Override
    public void addMethod(Method method) {
        LOGGER.info("Adding method " + method);
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target(TARGET)
                .path("method").path("add");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.post(Entity.entity(method, MediaType.APPLICATION_XML));
        int status = response.getStatus();
        LOGGER.info("Response from server" + response);
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot add method. Error code " + status);
        }

    }

    @Override
    public List<Method> takeMethodList(JsObject jsObject) {
        LOGGER.info("Taking method list for object" + jsObject);
        String idPath = Integer.toString(jsObject.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("method").path("list").path("for")
                .path("object").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        MethodList response = invocationBuilder.get(MethodList.class);
        return response.getMethodList();


    }

    @Override
    public void updateMethod(Method method) {
        LOGGER.info("Updating method " + method);
        String idPath = Integer.toString(method.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("method").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.put(Entity.entity(method, MediaType.APPLICATION_XML));
        LOGGER.info("Response from server" + response);
        int status = response.getStatus();
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot update method " + method + " Error code " + status);
        }
    }

    @Override
    public void deleteMethod(Method method) {

        LOGGER.info("Deleting method " + method);
        String idPath = Integer.toString(method.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("method").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request();
        Response response = invocationBuilder.delete();
        LOGGER.info("Response from server " + response);
        int status = response.getStatus();
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot delete method " + method + " Error code " + status);
        }
    }

    @Override
    public Method findMethodById(int id) {

        LOGGER.info("Trying to find method with id " + id);
        String idPath = Integer.toString(id);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("method").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Method response = invocationBuilder.get(Method.class);
        LOGGER.info("Found method successfully");
        return response;

    }

    @Override
    public Method findMethodByName(String name) {
        LOGGER.info("Trying to find method with name " + name);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("method").path("name").path(name);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Method response = invocationBuilder.get(Method.class);
        LOGGER.info("Found method successfully");
        return response;

    }

    @Override
    public void addJsObject(JsObject jsObject) {
        LOGGER.info("Trying to add js object " + jsObject);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("object").path("add");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.post(Entity.entity(jsObject, MediaType.APPLICATION_XML));
        LOGGER.info("Response from server " + response);
        int status = response.getStatus();
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot add js object. Error code " + status);
        }
    }

    @Override
    public List<JsObject> takeJsObjectList() {
        LOGGER.info("Trying to take list of js objects");
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("object").path("list");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        JsObjectList response = invocationBuilder.get(JsObjectList.class);
        return response.getJsObjectList();

    }

    @Override
    public void updateJsObject(JsObject jsObject) {
        LOGGER.info("Trying to update js object " + jsObject);
        String idPath = Integer.toString(jsObject.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("object").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.put(Entity.entity(jsObject, MediaType.APPLICATION_XML));
        LOGGER.info("Response from server " + response);
        int status = response.getStatus();
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot update js object " + jsObject + " Error code " + status);
        }
    }

    @Override
    public void deleteJsObject(JsObject jsObject) {

        LOGGER.info("Trying to delete js object " + jsObject);
        String idPath = Integer.toString(jsObject.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("object").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request();
        Response response = invocationBuilder.delete();

        LOGGER.info("Response from server " + response);
        int status = response.getStatus();
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot delete js object " + jsObject + " Error code " + status);
        }
    }

    @Override
    public JsObject findJsObjectById(int id) {

        LOGGER.info("Trying to find js object with id " + id);
        String idPath = Integer.toString(id);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("object").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        JsObject response = invocationBuilder.get(JsObject.class);
        return response;

    }

    @Override
    public JsObject findJsObjectByName(String name) {

        LOGGER.info("Trying to find js object with name " + name);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("object").path("name").path(name);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        JsObject response = invocationBuilder.get(JsObject.class);
        return response;
    }

    @Override
    public void addOperator(Operator operator) {

        LOGGER.info("Trying to add operator " + operator);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("operator").path("add");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.post(Entity.entity(operator, MediaType.APPLICATION_XML));
        int status = response.getStatus();

        LOGGER.info("Response from server " + response);
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot add operator. Error code " + status);
        }
    }

    @Override
    public List<Operator> takeOperatorList() {

        LOGGER.info("Trying to take operator list");
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("operator").path("list");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        OperatorList response = invocationBuilder.get(OperatorList.class);
        return response.getOperatorList();

    }

    @Override
    public void updateOperator(Operator operator) {

        LOGGER.info("Trying to update operator " + operator);
        String idPath = Integer.toString(operator.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("operator").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.put(Entity.entity(operator, MediaType.APPLICATION_XML));
        int status = response.getStatus();

        LOGGER.info("Response from server " + response);
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot update operator " + operator + " Error code " + status);
        }
    }

    @Override
    public void deleteOperator(Operator operator) {

        LOGGER.info("Trying to delete operator " + operator);
        String idPath = Integer.toString(operator.getId());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("operator").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request();
        Response response = invocationBuilder.delete();
        int status = response.getStatus();
        LOGGER.info("Response from server " + response);
        if (status != Response.Status.ACCEPTED.getStatusCode()) {
            throw new ProtocolException("Cannot delete operator " + operator + " Error code " + status);
        }
    }

    @Override
    public Operator findOperatorById(int id) {

        LOGGER.info("Trying to find operator with id " + id);
        String idPath = Integer.toString(id);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("operator").path(idPath);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.get();
        int status = response.getStatus();
        if (status == Response.Status.ACCEPTED.getStatusCode()) {
            return (Operator) response.getEntity();
        } else {
            throw new ProtocolException("Cannot take operator with id " + id +
                    "\n Error code " + status,
                    (Throwable) response.getEntity());
        }
    }

    @Override
    public Operator findOperatorByName(String name) {

        LOGGER.info("Trying to find operator with name " + name);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(TARGET)
                .path("operator").path("name").path(name);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Operator response = invocationBuilder.get(Operator.class);
        return response;
    }
}
