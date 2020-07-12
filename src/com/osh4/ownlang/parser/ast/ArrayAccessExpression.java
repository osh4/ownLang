package com.osh4.ownlang.parser.ast;

import java.util.List;

import com.osh4.ownlang.lib.ArrayValue;
import com.osh4.ownlang.lib.Value;
import com.osh4.ownlang.lib.Variables;

public class ArrayAccessExpression implements Expression
{
	public final String           variable;
	public final List<Expression> indices;

	public ArrayAccessExpression(String variable, List<Expression> indices)
	{
		this.variable = variable;
		this.indices = indices;
	}

	@Override
	public Value eval()
	{
		return getArray().get(lastIndex());
	}

	public ArrayValue getArray()
	{
		ArrayValue array = consumeArray(Variables.get(variable));
		final int last = indices.size() - 1;
		for (int i = 0; i < last; i++)
		{
			array = consumeArray(array.get(index(i)));
		}
		return array;
	}

	public int lastIndex()
	{
		return index(indices.size() - 1);
	}

	private int index(int index)
	{
		return (int) indices.get(index).eval().asNumber();
	}

	private ArrayValue consumeArray(final Value value)
	{
		if (value instanceof ArrayValue)
		{
			return (ArrayValue) value;
		}
		else
		{
			throw new RuntimeException("Array expected");
		}
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return variable + indices;
	}

}
