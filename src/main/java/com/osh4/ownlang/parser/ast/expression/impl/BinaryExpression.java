package com.osh4.ownlang.parser.ast.expression.impl;

import com.osh4.ownlang.value.impl.ArrayValue;
import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.impl.StringValue;
import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents binary operation expression.
 */
public final class BinaryExpression implements Expression
{
	public final Expression expr1, expr2;
	public final char operation;

	/**
	 * Constructor.
	 *
	 * @param operation operation like + - * /
	 * @param expr1     expression 1
	 * @param expr2     expression 2
	 */
	public BinaryExpression(final char operation, final Expression expr1, final Expression expr2)
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
					final int iterations = value2.asInt();
					return new StringValue(String.valueOf(string1).repeat(iterations));
				}
				case '+':
				default:
					return new StringValue(string1 + string2);
			}
		}

		final double number1 = value1.asDouble();
		final double number2 = value2.asDouble();
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
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return String.format("[%s %c %s]", expr1, operation, expr2);
	}
}
