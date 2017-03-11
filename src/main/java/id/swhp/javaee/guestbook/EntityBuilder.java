package id.swhp.javaee.guestbook;

import id.swhp.javaee.guestbook.boundary.MessageResources;
import id.swhp.javaee.guestbook.boundary.RootResources;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static javax.json.Json.createObjectBuilder;

/**
 * Responsible build Json Object from Entity
 *
 * @author Sukma Wardana
 * @since 1.0.0
 */
public class EntityBuilder {

    public JsonObject buildIndex(UriInfo uriInfo) {
        final URI self = uriInfo.getBaseUriBuilder().path(RootResources.class).build();
        final URI message = uriInfo.getBaseUriBuilder().path(MessageResources.class).build();
        final JsonObjectBuilder builder = createObjectBuilder();

        builder.add("_links", Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                        .add("rel", "self")
                        .add("href", self.toString())
                        .add("method", "GET")
                )
                .add(Json.createObjectBuilder()
                        .add("rel", "message")
                        .add("href", message.toString())
                        .add("method", "GET")
                )
        );

        return builder.build();
    }
}
