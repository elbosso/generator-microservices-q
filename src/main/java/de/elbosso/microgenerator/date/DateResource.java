package de.elbosso.microgenerator.date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateResource
{
	//https://www.baeldung.com/jackson-jsonformat
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private java.util.Date value;

	protected DateResource(java.util.Date value)
	{
		super();
		this.value=value;
	}

	public java.util.Date getValue()
	{
		return value;
	}
}
