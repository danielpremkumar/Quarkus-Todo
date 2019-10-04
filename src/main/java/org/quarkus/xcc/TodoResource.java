package org.quarkus.xcc;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * PromotionResource
 */
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @GET
    public List<Todo> getAll() {
        return Todo.listAll();
    }

    @POST
    @Transactional
    public Response add(Todo item) {
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(Todo item, @PathParam("id") Long id) {
        Todo entity = Todo.findById(id);
        entity.completed = item.completed;
        entity.order = item.order;
        entity.title = item.title;
        entity.id = id;
        return Response.status(200).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        Todo entity = Todo.findById(id);
        entity.delete();
        return Response.status(204).build();
    }
}