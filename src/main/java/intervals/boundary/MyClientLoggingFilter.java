package intervals.boundary;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.io.IOException;

@Provider
public class MyClientLoggingFilter implements ClientRequestFilter {

    private static final Logger LOG = Logger.getLogger(MyClientLoggingFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        // This will log the method (GET) and the full URL + Query Params
        LOG.infof("Outgoing REST Call: %s %s %s",
                  requestContext.getMethod(),
                  requestContext.getUri(),
                  requestContext.getHeaders().getFirst("Authorization").toString()
        );
    }
}
