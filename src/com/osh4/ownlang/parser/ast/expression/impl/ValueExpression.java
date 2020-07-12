package com.osh4.ownlang.parser.ast.expression.impl;

import com.osh4.ownlang.value.impl.BooleanValue;
import com.osh4.ownlang.value.impl.IntegerValue;
import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.impl.StringValue;
import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

public class ValueExpression implements Expression
{
	public final Value value;

	public ValueExpression(final double value)
	{
		this.value = new NumberValue(value);
	}

	public ValueExpression(final String value)
	{
		this.value = new StringValue(value);
	}

	public ValueExpression(final boolean value)
	{
		this.value = new BooleanValue(value);
	}

	public ValueExpression(final int value)
	{
		this.value = new IntegerValue(value);
	}

	@Override
	public Value eval()
	{
		return value;
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return value.asString();
	}
}
