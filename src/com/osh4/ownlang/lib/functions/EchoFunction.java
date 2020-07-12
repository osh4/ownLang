package com.osh4.ownlang.lib.functions;

import com.osh4.ownlang.lib.NumberValue;
import com.osh4.ownlang.lib.Value;

public class EchoFunction implements Function
{
	private static final Value ZERO = new NumberValue(0);

	@Override
	public Value execute(Value... args)
	{
		for (Value arg : args)
		{
			System.out.print(arg.asString());
		}
		return ZERO;
	}
}
