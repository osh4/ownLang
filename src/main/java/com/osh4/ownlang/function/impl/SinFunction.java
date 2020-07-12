package com.osh4.ownlang.function.impl;

import com.osh4.ownlang.function.Function;
import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.Value;

/**
 * Define sin function.
 */
public final class SinFunction implements Function
{
	@Override
	public Value execute(final Value... args)
	{
		if (args.length != 1)
		{
			throw new RuntimeException("One arg expected");
		}
		return new NumberValue(Math.sin(args[0].asDouble()));
	}
}
