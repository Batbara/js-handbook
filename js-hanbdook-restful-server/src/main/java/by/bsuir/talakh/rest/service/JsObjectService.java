package by.bsuir.talakh.rest.service;

import by.bsuir.talakh.rest.dao.DaoException;
import by.bsuir.talakh.rest.dao.DaoFactory;
import by.bsuir.talakh.rest.dao.JsObjectDao;
import by.bsuir.talakh.rest.entity.JsObject;
import by.bsuir.talakh.rest.entity.JsObjectList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/object")
public class JsObjectService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getJsObjectById(@PathParam("id") String id) {
        int jsObjectId = Integer.parseInt(id);
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        try {
            JsObject jsObject = jsObjectDao.findById(jsObjectId);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(jsObject)
                    .build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getJsObjectByName(@PathParam("name") String name) {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        try {
            JsObject jsObject = jsObjectDao.findByName(name);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(jsObject)
                    .build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_XML)
    public Response getJsObjectList() {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        try {
            List<JsObject> jsObjects = jsObjectDao.takeAll();
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(new JsObjectList(jsObjects))
                    .build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addJsObject(JsObject jsObject) {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        try {
            jsObjectDao.addObject(jsObject);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteJsObject(@PathParam("id") String id) {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        try {
            int jsObjectId = Integer.parseInt(id);
            JsObject objectToDelete = new JsObject();
            objectToDelete.setId(jsObjectId);

            jsObjectDao.deleteObject(objectToDelete);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response updateJsObject(@PathParam("id") String id, JsObject jsObject) {
        JsObjectDao jsObjectDao = DaoFactory.getInstance().getJsObjectDao();
        try {
            jsObject.setId(Integer.parseInt(id));
            jsObjectDao.updateObject(jsObject);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }
}
