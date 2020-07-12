package com.osh4.ownlang.parser.ast;

import java.util.List;

import com.osh4.ownlang.lib.ArrayValue;
import com.osh4.ownlang.lib.Value;

public class ArrayExpression implements Expression
{
	public final List<Expression> elements;

	public ArrayExpression(List<Expression> elements)
	{
		this.elements = elements;
	}

	@Override
	public Value eval()
	{
		final int size = elements.size();
		final ArrayValue array = new ArrayValue(size);
		for (int i = 0; i < size; i++)
		{
			array.set(i, elements.get(i).eval());
		}
		return array;
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return elements.toString();
	}
}
