package com.osh4.ownlang.parser.ast;

import com.osh4.ownlang.lib.ArrayValue;
import com.osh4.ownlang.lib.NumberValue;
import com.osh4.ownlang.lib.StringValue;
import com.osh4.ownlang.lib.Value;

public class BinaryExpression implements Expression
{
	public final Expression expr1, expr2;
	public final char operation;

	public BinaryExpression(char operation, Expression expr1, Expression expr2)
	{
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operation = operation;
	}

	@Override
	public Value eval()
	{
		final Value value1 = expr1.eval();
		final Value value2 = expr2.eval();
		if (value1 instanceof StringValue || value1 instanceof ArrayValue)
		{
			final String string1 = value1.asString();
			final String string2 = value2.asString();
			switch (operation)
			{
				case '*':
				{
					final int iterations = (int) value2.asNumber();
					return new StringValue(String.valueOf(string1).repeat(iterations));
				}
				case '+':
				default:
					return new StringValue(string1 + string2);
			}
		}

		final double number1 = value1.asNumber();
		final double number2 = value2.asNumber();
		switch (operation)
		{
			case '-':
				return new NumberValue(number1 - number2);
			case '*':
				return new NumberValue(number1 * number2);
			case '/':
				return new NumberValue(number1 / number2);
			case '+':
			default:
				return new NumberValue(number1 + number2);

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
		return String.format("[%s %c %s]", expr1, operation, expr2);
	}
}
