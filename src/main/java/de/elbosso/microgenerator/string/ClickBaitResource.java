package de.elbosso.microgenerator.string;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/clickBaitSequence")
public class ClickBaitResource
{
    private final de.elbosso.util.generator.semantics.ClickBaitSequence clickBaitSequence=new de.elbosso.util.generator.semantics.ClickBaitSequence();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(new StringResource(clickBaitSequence.next())).build();
    }
}