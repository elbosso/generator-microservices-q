package de.elbosso.microgenerator;

public class ValueResource<T> extends java.lang.Object
{
	private T value;

	protected ValueResource(T value)
	{
		super();
		this.value=value;
	}

	public T getValue()
	{
		return value;
	}
}
