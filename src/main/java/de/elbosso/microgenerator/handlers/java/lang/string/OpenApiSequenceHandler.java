/*
Copyright (c) 2012-2020.

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

import de.elbosso.util.generator.semantics.openapi.Config;
import de.elbosso.util.generator.semantics.xml.Customizations;
import de.elbosso.util.generator.semantics.xml.SchemaAnalyzer;
import org.apache.xmlbeans.XmlException;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Collections;

//http://www.adam-bien.com/roller/abien/entry/sending_and_receiving_streams_with
//https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/using-query-param.html
//https://antoniogoncalves.org/2019/06/07/configuring-a-quarkus-application/

@Path("/openApiFragment")
public class OpenApiSequenceHandler
{
    //java.lang.String
    @GET
    @Produces("application/json")
    public String get(
			@DefaultValue("https://petstore3.swagger.io/api/v3/openapi.json")
	@QueryParam("OpenApiSpec")
	String openApiSpec
	) throws URISyntaxException, JSONException, IOException
	{
		java.net.URI schemaUri=new java.net.URI(openApiSpec);
		StringWriter writer = new StringWriter();
		de.elbosso.util.generator.semantics.openapi.OpenApi openAPI = new de.elbosso.util.generator.semantics.openapi.OpenApi(Collections.EMPTY_MAP,new Config(),new java.net.URI(openApiSpec));
		java.util.Collection<java.lang.String> schemaTypeNames=openAPI.getSchemaTypeNames();
		java.io.PrintWriter pw=new java.io.PrintWriter(writer);
		org.json.JSONObject obj=new org.json.JSONObject();
		for(java.lang.String schemaTypeName:schemaTypeNames)
		{
			obj.put(schemaTypeName,openAPI.produceJson(schemaTypeName));
		}
		pw.println(obj.toString(2));
		pw.close();

		writer.close();
		return writer.toString();
	}
}

