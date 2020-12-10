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

import de.elbosso.util.generator.semantics.xml.Customizations;
import de.elbosso.util.generator.semantics.xml.SchemaAnalyzer;
import org.apache.xmlbeans.XmlException;
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


@Path("/xmlFragment")
public class XmlFragmentSequenceHandler
{
	private de.elbosso.util.generator.semantics.VCardSequence vCardSequence=new de.elbosso.util.generator.semantics.VCardSequence();

    //java.lang.String
    @GET
    @Produces("text/xml")
    public String get(
			@DefaultValue("http://tecfa.unige.ch/guides/xml/examples/xsd-examples/recipe.xsd")
	@QueryParam("Schema")
	String schema,
	@DefaultValue("list")
	@QueryParam("RootElementName")
	String rootElementName
	) throws URISyntaxException, XmlException, SAXException, TransformerException, IOException
	{
		java.net.URI schemaUri=new java.net.URI(schema);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		SchemaAnalyzer.generate(schemaUri,result,rootElementName, new Customizations(Collections.emptyMap(),Collections.EMPTY_MAP));
		writer.close();
		return writer.toString();
	}
}

