package com.osh4.ownlang.lib;

import com.osh4.ownlang.lib.functions.Function;

public class NewarrayFunction implements Function
{
	@Override
	public Value execute(Value... args)
	{
		return createArray(args, 0);
	}

	private ArrayValue createArray(Value[] args, int index)
	{
		final int size = (int) args[index].asNumber();
		final int lastIndex = args.length - 1;
		ArrayValue array = new ArrayValue(size);
		if (index == lastIndex)
		{
			for (int i = 0; i < size; i++)
			{
				array.set(i, NumberValue.ZERO);
			}
		}
		else if (index < lastIndex)
		{
			for (int i = 0; i < size; i++)
			{
				array.set(i, createArray(args, index + 1));
			}
		}
		return array;
	}
}
