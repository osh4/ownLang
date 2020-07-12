package com.osh4.ownlang.function.impl;

import com.osh4.ownlang.function.Function;
import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.Value;

/**
 * Define function for console output.
 */
public final class EchoFunction implements Function
{
	private static final Value ZERO = new NumberValue(0);

	@Override
	public Value execute(final Value... args)
	{
		for (Value arg : args)
		{
			System.out.print(arg.asString());
		}
		return ZERO;
	}
}
