package id.swhp.javaee.guestbook.boundary;

import id.swhp.javaee.guestbook.entity.GuestBook;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
@Path("messages")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MessageResources {

    @Inject
    Message message;

    @GET
    public JsonArray findAll() {
        JsonArrayBuilder list = Json.createArrayBuilder();
        List<GuestBook> all = this.message.findAll();
        all.stream().map(GuestBook::toJson).forEach(list::add);
        return list.build();
    }

    @GET
    @Path("{id}")
    public JsonObject findById(@PathParam("id") Long id) {
        GuestBook guestBook = this.message.findById(id);
        return guestBook.toJson();
    }

    @POST
    public Response save(@Valid GuestBook guestBook) {
        this.message.create(guestBook);
        return Response.ok().build();
    }
}
