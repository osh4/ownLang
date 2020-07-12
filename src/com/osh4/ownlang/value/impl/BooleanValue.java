package com.osh4.ownlang.value.impl;

/**
 * Represents double value.
 */
public final class BooleanValue extends NumberValue
{
	/**
	 * Constructor.
	 *
	 * @param value boolean value
	 */
	public BooleanValue(boolean value)
	{
		super(value ? 1 : 0);
	}

}
