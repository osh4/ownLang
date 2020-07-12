package com.osh4.ownlang.value.impl;

import com.osh4.ownlang.value.Value;

/**
 * Represents double value.
 */
public class NumberValue implements Value
{
	private final       double value;
	//public static final Value  ZERO = new NumberValue(0);

	public NumberValue()
	{
		this.value = 0;
	}

	/**
	 * Constructor.
	 *
	 * @param value double value
	 */
	public NumberValue(double value)
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
		return (int) value;
	}

	@Override
	public String toString()
	{
		return asString();
	}
}
