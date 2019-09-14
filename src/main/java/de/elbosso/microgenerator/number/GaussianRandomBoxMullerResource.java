package de.elbosso.microgenerator.number;

import de.elbosso.microgenerator.string.StringResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gaussianRandomBoxMuller")
public class GaussianRandomBoxMullerResource
{
    private final de.elbosso.util.generator.generalpurpose.GaussianRandomBoxMuller gaussianRandomBoxMuller=new de.elbosso.util.generator.generalpurpose.GaussianRandomBoxMuller();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(new NumberResource(gaussianRandomBoxMuller.next())).build();
    }
}