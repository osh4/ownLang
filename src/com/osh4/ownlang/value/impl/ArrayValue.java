package com.osh4.ownlang.value.impl;

import java.util.Arrays;

import com.osh4.ownlang.value.Value;

/**
 * Represents array value.
 */
public final class ArrayValue implements Value
{
	private final Value[] elements;

	public ArrayValue(final Value[] elements)
	{
		this.elements = new Value[elements.length];
		System.arraycopy(elements, 0, this.elements, 0, elements.length);
	}

	public ArrayValue(final int size)
	{
		this.elements = new Value[size];
	}

	public ArrayValue(final ArrayValue array)
	{
		this(array.elements);
	}

	public Value get(final int index)
	{
		return elements[index];
	}

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
