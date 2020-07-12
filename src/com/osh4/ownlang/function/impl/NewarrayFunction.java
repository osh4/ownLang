package com.osh4.ownlang.function.impl;

import com.osh4.ownlang.function.Function;
import com.osh4.ownlang.value.impl.ArrayValue;
import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.Value;

/**
 * Define function for new array creating.
 */
public final class NewarrayFunction implements Function
{
	@Override
	public Value execute(final Value... args)
	{
		return createArray(args, 0);
	}

	private ArrayValue createArray(final Value[] args, final int index)
	{
		final int size = args[index].asInt();
		final int lastIndex = args.length - 1;
		ArrayValue array = new ArrayValue(size);
		if (index == lastIndex)
		{
			for (int i = 0; i < size; i++)
			{
				array.set(i, Value.ZERO);
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
