package com.osh4.ownlang.lib.functions;

import com.osh4.ownlang.lib.NumberValue;
import com.osh4.ownlang.lib.Value;

public class SinFunction implements Function
{
	@Override
	public Value execute(Value... args)
	{
		if (args.length != 1)
		{
			throw new RuntimeException("One arg expected");
		}
		return new NumberValue(Math.sin(args[0].asNumber()));
	}
}
