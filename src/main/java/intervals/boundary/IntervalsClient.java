package intervals.boundary;

import io.quarkus.rest.client.reactive.ClientBasicAuth;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
@ApplicationScoped
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@RegisterRestClient(configKey = "intervals-client")
@ClientBasicAuth(username = "${intervals-client.username}", password = "${intervals-client.password}")
//@ClientHeaderParam(name = "Authorization", value = "{computeAuth}")
public interface IntervalsClient {

    @GET
    @Path("/athlete/0/activities")
    List<ActivitySummary> getActivities(@QueryParam("oldest") String oldest, @QueryParam("fields") List<String> fields, @QueryParam("limit") int i);

//    default String computeAuth() {
//        String auth = "API_KEY:61nicdavdl7g7b643qigby0xc";
//        return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
//    }
}
