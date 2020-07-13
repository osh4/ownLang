package com.osh4.ownlang.value.impl;

import java.util.Arrays;

import com.osh4.ownlang.value.Value;

/**
 * Represents array value.
 */
public final class ArrayValue implements Value
{
	private final Value[] elements;

	/**
	 * Constructor.
	 *
	 * @param elements array elements
	 */
	public ArrayValue(final Value[] elements)
	{
		this.elements = new Value[elements.length];
		System.arraycopy(elements, 0, this.elements, 0, elements.length);
	}

	/**
	 * Constructor.
	 *
	 * @param size array size
	 */
	public ArrayValue(final int size)
	{
		this.elements = new Value[size];
	}

	/**
	 * Constructor.
	 *
	 * @param array source array
	 */
	public ArrayValue(final ArrayValue array)
	{
		this(array.elements);
	}

	/**
	 * Gets array element by index.
	 *
	 * @param index index of element to get
	 *
	 * @return element
	 */
	public Value get(final int index)
	{
		return elements[index];
	}

	/**
	 * Sets array element by index.
	 *
	 * @param index index of element to get
	 * @param value value
	 */
	public void set(final int index, final Value value)
	{
		elements[index] = value;
	}

	@Override
	public double asDouble()
	{
		throw new RuntimeException("Can't cast array to double");
	}

	@Override
	public int asInt()
	{
		throw new RuntimeException("Can't cast array to int");
	}

	@Override
	public String asString()
	{
		return Arrays.toString(elements);
	}

	@Override
	public String toString()
	{
		return asString();
	}
}
