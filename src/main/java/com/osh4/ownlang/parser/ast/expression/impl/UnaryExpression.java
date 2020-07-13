package com.osh4.ownlang.parser.ast.expression.impl;

import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents unary operations (like sign of number).
 */
public final class UnaryExpression implements Expression
{
	public final Expression expr1;
	public final char       operation;

	/**
	 * Constructor.
	 *
	 * @param operation operation (+ -)
	 * @param expr1     expression for the operation to apply
	 */
	public UnaryExpression(final char operation, final Expression expr1)
	{
		this.expr1 = expr1;
		this.operation = operation;
	}

	@Override
	public Value eval()
	{
		switch (operation)
		{
			case '-':
				return new NumberValue(-expr1.eval().asDouble());
			case '+':
			default:
				return expr1.eval();
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
		return String.format("%c %s", operation, expr1);
	}
}
