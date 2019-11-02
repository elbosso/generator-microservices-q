package de.elbosso.microgenerator.image;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

//http://www.adam-bien.com/roller/abien/entry/sending_and_receiving_streams_with
//https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/using-query-param.html
//https://antoniogoncalves.org/2019/06/07/configuring-a-quarkus-application/

@Path("/qrCodeImageSequence")
public class QRCodeImageResource
{
    private final de.elbosso.util.generator.generalpurpose.QRCodeImageSequence qrCodeImageSequence=new de.elbosso.util.generator.generalpurpose.QRCodeImageSequence();

    @GET
    @Produces("image/png")
    public StreamingOutput hello(@QueryParam("dim") @DefaultValue("320") int dim)
    {
        return greeting(dim);
    }
    @GET
    @Produces("image/png")
    @Path("/{dim}")
    public StreamingOutput greeting(@PathParam("dim") int dim) {
        qrCodeImageSequence.setDimensionWidth(dim);
        StreamingOutput rv= new StreamingOutput() {
            @Override
            public void write(OutputStream output)
                    throws IOException, WebApplicationException
            {
                javax.imageio.ImageIO.write(qrCodeImageSequence.next(),"png",output);
            }
        };
        return rv;
    }
}