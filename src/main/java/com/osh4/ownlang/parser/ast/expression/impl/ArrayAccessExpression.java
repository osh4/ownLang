package com.osh4.ownlang.parser.ast.expression.impl;

import java.util.List;

import com.osh4.ownlang.value.impl.ArrayValue;
import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.lib.Variables;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

public class ArrayAccessExpression implements Expression
{
	public final String           variable;
	public final List<Expression> indices;

	public ArrayAccessExpression(final String variable, final List<Expression> indices)
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

	private int index(final int index)
	{
		return indices.get(index).eval().asInt();
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
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return variable + indices;
	}

}
