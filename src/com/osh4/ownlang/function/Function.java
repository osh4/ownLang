package com.osh4.ownlang.function;

import com.osh4.ownlang.value.Value;

public interface Function
{
	/**
	 * Define function used in own language.
	 *
	 * @param args function arguments
	 *
	 * @return value calculated in function
	 */
	Value execute(Value... args);
}
