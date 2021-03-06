package id.swhp.javaee.guestbook;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Responsible to build URI for resources class
 *
 * @author Sukma Wardana
 * @since 1.0.0
 */
public class ResourceUriBuilder {

    public URI createResourceUri(Class<?> resourcesClass, UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(resourcesClass).build();
    }

    public URI createResourceUri(Class<?> resourcesClass, String method, long id, UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(resourcesClass).path(resourcesClass, method).build(id);
    }
}
