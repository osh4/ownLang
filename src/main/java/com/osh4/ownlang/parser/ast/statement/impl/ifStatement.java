package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.Expression;

/**
 * Represents if branching.
 */
public final class ifStatement implements Statement
{
	public final Expression expression;
	public final Statement  ifStatemenet, elseStatemenet;

	/**
	 * Constructor.
	 *
	 * @param expression    body of "if"
	 * @param ifStatement   "if" section statement
	 * @param elseStatement "else" section statement
	 */
	public ifStatement(final Expression expression, final Statement ifStatement, final Statement elseStatement)
	{
		this.expression = expression;
		this.ifStatemenet = ifStatement;
		this.elseStatemenet = elseStatement;
	}

	@Override
	public void execute()
	{
		final double result = expression.eval().asDouble();
		if (result != 0)
		{
			ifStatemenet.execute();
		}
		else if (elseStatemenet != null)
		{
			elseStatemenet.execute();
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
		final StringBuilder result = new StringBuilder();
		result.append("if ").append(expression).append(' ').append(ifStatemenet);
		if (elseStatemenet != null)
		{
			result.append("\nelse ").append(elseStatemenet);
		}
		return result.toString();
	}
}
