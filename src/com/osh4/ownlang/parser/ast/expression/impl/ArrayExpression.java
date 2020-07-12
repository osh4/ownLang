package com.osh4.ownlang.parser.ast.expression.impl;

import java.util.List;

import com.osh4.ownlang.value.impl.ArrayValue;
import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

public class ArrayExpression implements Expression
{
	public final List<Expression> elements;

	public ArrayExpression(final List<Expression> elements)
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
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return elements.toString();
	}
}
