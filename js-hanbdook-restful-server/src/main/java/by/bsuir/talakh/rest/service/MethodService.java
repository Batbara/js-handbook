package by.bsuir.talakh.rest.service;

import by.bsuir.talakh.rest.dao.DaoException;
import by.bsuir.talakh.rest.dao.DaoFactory;
import by.bsuir.talakh.rest.dao.MethodDao;
import by.bsuir.talakh.rest.entity.Method;
import by.bsuir.talakh.rest.entity.MethodList;

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

@Path("/method")
public class MethodService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getMethodById(@PathParam("id") String id) {
        int methodId = Integer.parseInt(id);
        System.out.println("someone trying to get method by id");
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();

        Method method = methodDao.findById(methodId);
        return Response
                .status(Response.Status.ACCEPTED)
                .entity(method)
                .build();


    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getMethodByName(@PathParam("name") String name) {
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        try {
            Method method = methodDao.findByName(name);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(method)
                    .build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause())
                    .build();
        }
    }

    @GET
    @Path("/list/for/object/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getMethodList(@PathParam("id") String id) {
        int objectId = Integer.parseInt(id);
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        try {
            List<Method> methods = methodDao.takeAll(objectId);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(new MethodList(methods))
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
    public Response addMethod(Method method) {
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        try {
            methodDao.addMethod(method);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteMethod(@PathParam("id") String id) {
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        try {
            Method method = new Method();
            method.setId(Integer.parseInt(id));
            methodDao.deleteMethod(method);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response updateMethod(@PathParam("id") String id, Method method) {
        MethodDao methodDao = DaoFactory.getInstance().getMethodDao();
        try {
            methodDao.updateMethod(method);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }

}
