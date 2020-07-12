package com.osh4.ownlang.value.impl;

import com.osh4.ownlang.value.Value;

/**
 * Represents string value.
 */
public final class StringValue implements Value
{
	private final String value;

	/**
	 * Constructor.
	 *
	 * @param value value
	 */
	public StringValue(final String value)
	{
		this.value = value;
	}

	@Override
	public double asDouble()
	{
		try
		{
			return Double.parseDouble(value);
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}

	@Override
	public String asString()
	{
		return value;
	}

	@Override
	public int asInt()
	{
		return (int) asDouble();
	}

	@Override
	public String toString()
	{
		return asString();
	}
}
