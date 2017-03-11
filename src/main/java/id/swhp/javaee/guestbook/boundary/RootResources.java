package id.swhp.javaee.guestbook.boundary;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Implemented Rest Hypermedia which is root URI should have list of the resources
 *
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
@Path("/")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RootResources {

    @Context
    UriInfo uriInfo;

    @GET
    public JsonObject getIndex() {
        final URI uri = this.uriInfo.getBaseUriBuilder().path(RootResources.class).build();
        return Json.createObjectBuilder()
                .add("_links", Json.createObjectBuilder()
                        .add("messages", uri.toString())
                ).build();
    }
}
