/*
Copyright (c) 2012-2021.

Juergen Key. Alle Rechte vorbehalten.

Weiterverbreitung und Verwendung in nichtkompilierter oder kompilierter Form, 
mit oder ohne Veraenderung, sind unter den folgenden Bedingungen zulaessig:

   1. Weiterverbreitete nichtkompilierte Exemplare muessen das obige Copyright, 
die Liste der Bedingungen und den folgenden Haftungsausschluss im Quelltext 
enthalten.
   2. Weiterverbreitete kompilierte Exemplare muessen das obige Copyright, 
die Liste der Bedingungen und den folgenden Haftungsausschluss in der 
Dokumentation und/oder anderen Materialien, die mit dem Exemplar verbreitet 
werden, enthalten.
   3. Weder der Name des Autors noch die Namen der Beitragsleistenden 
duerfen zum Kennzeichnen oder Bewerben von Produkten, die von dieser Software 
abgeleitet wurden, ohne spezielle vorherige schriftliche Genehmigung verwendet 
werden.

DIESE SOFTWARE WIRD VOM AUTOR UND DEN BEITRAGSLEISTENDEN OHNE 
JEGLICHE SPEZIELLE ODER IMPLIZIERTE GARANTIEN ZUR VERFUEGUNG GESTELLT, DIE 
UNTER ANDEREM EINSCHLIESSEN: DIE IMPLIZIERTE GARANTIE DER VERWENDBARKEIT DER 
SOFTWARE FUER EINEN BESTIMMTEN ZWECK. AUF KEINEN FALL IST DER AUTOR 
ODER DIE BEITRAGSLEISTENDEN FUER IRGENDWELCHE DIREKTEN, INDIREKTEN, 
ZUFAELLIGEN, SPEZIELLEN, BEISPIELHAFTEN ODER FOLGENDEN SCHAEDEN (UNTER ANDEREM 
VERSCHAFFEN VON ERSATZGUETERN ODER -DIENSTLEISTUNGEN; EINSCHRAENKUNG DER 
NUTZUNGSFAEHIGKEIT; VERLUST VON NUTZUNGSFAEHIGKEIT; DATEN; PROFIT ODER 
GESCHAEFTSUNTERBRECHUNG), WIE AUCH IMMER VERURSACHT UND UNTER WELCHER 
VERPFLICHTUNG AUCH IMMER, OB IN VERTRAG, STRIKTER VERPFLICHTUNG ODER 
UNERLAUBTE HANDLUNG (INKLUSIVE FAHRLAESSIGKEIT) VERANTWORTLICH, AUF WELCHEM 
WEG SIE AUCH IMMER DURCH DIE BENUTZUNG DIESER SOFTWARE ENTSTANDEN SIND, SOGAR, 
WENN SIE AUF DIE MOEGLICHKEIT EINES SOLCHEN SCHADENS HINGEWIESEN WORDEN SIND.
*/
package de.elbosso.microgenerator.handlers.java.lang.string;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

//http://www.adam-bien.com/roller/abien/entry/sending_and_receiving_streams_with
//https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/using-query-param.html
//https://antoniogoncalves.org/2019/06/07/configuring-a-quarkus-application/



@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2021-01-29T15:07:37.656Z")
@Path("/product")
public class ProductSequenceHandler
{
	private final de.elbosso.util.generator.semantics.ProductSequence generator=new de.elbosso.util.generator.semantics.ProductSequence();

    //java.lang.String
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get()
    {
        return Response.ok(new de.elbosso.microgenerator.string.StringResource(generator.next())).build();
    }
/*
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
*/
}

