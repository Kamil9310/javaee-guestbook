package id.swhp.javaee.guestbook.boundary;

import id.swhp.javaee.guestbook.entity.GuestBook;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public List<GuestBook> findAll() {
        return this.message.findAll();
    }

    @GET
    @Path("{id}")
    public GuestBook findById(@PathParam("id") Long id) {
        return this.message.findById(id);
    }

    @POST
    public void save(GuestBook guestBook) {
        this.message.create(guestBook);
    }
}
