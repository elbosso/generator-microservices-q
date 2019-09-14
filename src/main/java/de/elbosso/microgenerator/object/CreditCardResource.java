package de.elbosso.microgenerator.object;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/creditCardSequence")
public class CreditCardResource
{
    private final de.elbosso.util.generator.semantics.CreditCardSequence creditCardSequence=new de.elbosso.util.generator.semantics.CreditCardSequence();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(creditCardSequence.next()).build();
    }
}