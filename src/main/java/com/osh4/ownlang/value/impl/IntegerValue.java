package com.osh4.ownlang.value.impl;

import com.osh4.ownlang.value.Value;

/**
 * Represents double value.
 */
public class IntegerValue implements Value
{
	private final       int   value;

	/**
	 * Constructor.
	 *
	 * @param value double value
	 */
	public IntegerValue(final int value)
	{
		this.value = value;
	}

	@Override
	public double asDouble()
	{
		return value;
	}

	@Override
	public String asString()
	{
		return Double.toString(value);
	}

	@Override
	public int asInt()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return asString();
	}
}
