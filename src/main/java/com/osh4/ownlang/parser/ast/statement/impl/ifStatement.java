package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.Expression;

public class ifStatement implements Statement
{
	public final Expression expression;
	public final Statement  ifStatemenet, elseStatemenet;

	public ifStatement(final Expression expression, final Statement ifStatemenet, final Statement elseStatemenet)
	{
		this.expression = expression;
		this.ifStatemenet = ifStatemenet;
		this.elseStatemenet = elseStatemenet;
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
