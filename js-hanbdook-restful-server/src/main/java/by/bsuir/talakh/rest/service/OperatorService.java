package by.bsuir.talakh.rest.service;

import by.bsuir.talakh.rest.dao.DaoException;
import by.bsuir.talakh.rest.dao.DaoFactory;
import by.bsuir.talakh.rest.dao.OperatorDao;
import by.bsuir.talakh.rest.entity.Operator;
import by.bsuir.talakh.rest.entity.OperatorList;

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

@Path("/operator")
public class OperatorService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getOperatorById(@PathParam("id") String id) {
        int operatorId = Integer.parseInt(id);
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        try {
            Operator operator = operatorDao.findById(operatorId);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(operator)
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
    public Response getOperatorByName(@PathParam("name") String name) {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        try {
            Operator operator = operatorDao.findByName(name);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(operator)
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
    public Response getOperatorList() {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        try {
            List<Operator> operators = operatorDao.takeAll();
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(new OperatorList(operators))
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
    public Response addOperator(Operator operator) {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        try {
            operatorDao.addOperator(operator);
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
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteOperator(@PathParam("id") String id) {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        try {
            Operator operator = new Operator();
            operator.setId(Integer.parseInt(id));
            operatorDao.deleteOperator(operator);
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
    public Response updateOperator(@PathParam("id") String id, Operator operator) {
        OperatorDao operatorDao = DaoFactory.getInstance().getOperatorDao();
        try {
            operator.setId(Integer.parseInt(id));
            operatorDao.updateOperator(operator);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (DaoException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }
}
