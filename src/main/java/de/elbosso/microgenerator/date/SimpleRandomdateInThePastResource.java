package de.elbosso.microgenerator.date;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/simpleRandomDateInThePastSequence")
public class SimpleRandomdateInThePastResource
{
    private final de.netsysit.util.generator.generalpurpose.SimpleRandomDateInThePastSequence simpleRandomDateInThePastSequence=new de.netsysit.util.generator.generalpurpose.SimpleRandomDateInThePastSequence();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(new DateResource(simpleRandomDateInThePastSequence.next())).build();
    }
}