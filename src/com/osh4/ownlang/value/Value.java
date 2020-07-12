package com.osh4.ownlang.value;

import com.osh4.ownlang.value.impl.IntegerValue;

/**
 * Represents values in own language.
 */
public interface Value
{
	/**
	 * Represents zero value.
	 */
	Value ZERO = new IntegerValue(0);

	/**
	 * Returns double number representation of Value.
	 *
	 * @return double value
	 */
	double asDouble();

	/**
	 * Returns string representation of Value.
	 *
	 * @return string value
	 */
	String asString();

	/**
	 * Returns number representation of Value.
	 *
	 * @return int value
	 */
	int asInt();
}
