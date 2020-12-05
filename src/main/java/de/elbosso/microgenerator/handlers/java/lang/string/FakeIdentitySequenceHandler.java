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

import net.fortuna.ical4j.util.MapTimeZoneCache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.IOException;
import de.elbosso.util.Stringifier;
import de.elbosso.util.generator.JsonGeneratorBuilder;
import de.elbosso.util.generator.generalpurpose.StringifierSequence;
import de.elbosso.util.generator.semantics.*;
import de.netsysit.util.generator.generalpurpose.RandomFloatSequence;
import de.netsysit.util.generator.generalpurpose.SimpleRandomDateInThePastSequence;
import de.netsysit.util.generator.semantics.*;
import de.netsysit.util.geo.mashups.Placemark;
import org.json.JSONException;

//http://www.adam-bien.com/roller/abien/entry/sending_and_receiving_streams_with
//https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/using-query-param.html
//https://antoniogoncalves.org/2019/06/07/configuring-a-quarkus-application/


@Path("/fakeIdentity")
public class FakeIdentitySequenceHandler
{
	private final de.netsysit.util.generator.generalpurpose.SimpleRandomDateInThePastSequence rdpast = new SimpleRandomDateInThePastSequence();
	private final CreditCardSequence ccnseq = new CreditCardSequence();
	private final FamilyBusinessSequence bs = new FamilyBusinessSequence();
	private final SurNameSequence sns = new SurNameSequence();
	private final GivenNameSequence gbs=new GivenNameSequence();
	private final PlacesSequence placesSequence=new PlacesSequence();
	private final HausNummerSequence hausNummerSequence=new HausNummerSequence();
	private final ZipSequence zs=new ZipSequence();
	private final AddressSequence addressSequence=new AddressSequence();
	private final EMailAddressSequence eMailAddressSequence=new EMailAddressSequence();
	private final PhoneNumberSequence phoneNumberSequence=new PhoneNumberSequence();
	private final PhoneNumberSequence faxNumberSequence=new PhoneNumberSequence();
	private final GuruProfessionSequence guruProfessionSequence=new GuruProfessionSequence();
	private final JsonGeneratorBuilder addressJsonGeneratorBuilder;
	private final JsonGeneratorBuilder officeGeneratorBuilder;
	private final JsonGeneratorBuilder rootJsonGeneratorBuilder;

	public FakeIdentitySequenceHandler()
	{
		super();
		phoneNumberSequence.setIncludeCell(true);
		faxNumberSequence.setIncludeCell(false);
		addressJsonGeneratorBuilder =
				new JsonGeneratorBuilder()
						.put("Town", placesSequence)
						.put("Zip", zs)
						.put("Street", addressSequence)
						.put("Number", hausNummerSequence);

		officeGeneratorBuilder=
				new JsonGeneratorBuilder()
						.putObject("address",addressJsonGeneratorBuilder)
						.put("name",bs)
						.put("email",eMailAddressSequence)
						.put("fax",faxNumberSequence)
						.put("phone",phoneNumberSequence);

		rootJsonGeneratorBuilder =
				new JsonGeneratorBuilder()
						.put("name",sns)
						.put("givenname",gbs)
						.put("birthday",rdpast)
						.put("email",eMailAddressSequence)
						.put("phone",phoneNumberSequence)
						.put("mothersmaidenname", sns)
						.put("position",guruProfessionSequence)
						.put("creditcard",ccnseq)
				.putObject("address",addressJsonGeneratorBuilder)
				.putObject("office",officeGeneratorBuilder);

	}
    //java.lang.String
    @GET
    @Produces("application/json")
    public Response get()
    {
        java.io.StringWriter sw=new java.io.StringWriter();
        return Response.ok(rootJsonGeneratorBuilder.next().toString()).build();
    }
}

