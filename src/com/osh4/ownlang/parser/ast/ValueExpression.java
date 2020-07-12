package com.osh4.ownlang.parser.ast;

import com.osh4.ownlang.lib.NumberValue;
import com.osh4.ownlang.lib.StringValue;
import com.osh4.ownlang.lib.Value;

public class ValueExpression implements Expression
{
	public final Value value;

	public ValueExpression(double value)
	{
		this.value = new NumberValue(value);
	}

	public ValueExpression(String value)
	{
		this.value = new StringValue(value);
	}

	@Override
	public Value eval()
	{
		return value;
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return value.asString();
	}
}
