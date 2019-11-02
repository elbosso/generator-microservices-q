package de.elbosso.microgenerator.string;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/landmarkNameSequence")
public class LandmarkNameResource
{
    private final de.elbosso.util.generator.semantics.LandmarkNameSequence landmarkNameSequence=new de.elbosso.util.generator.semantics.LandmarkNameSequence();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(new StringResource(landmarkNameSequence.next())).build();
    }
}