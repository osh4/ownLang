package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.Expression;

public class WhileStatement implements Statement
{
	public final Expression condition;
	public final Statement  statement;

	public WhileStatement(final Expression condition, final Statement statement)
	{
		this.condition = condition;
		this.statement = statement;
	}

	@Override
	public void execute()
	{
		while (condition.eval().asDouble() != 0)
		{
			try
			{
				statement.execute();
			}
			catch (BreakStatement bs)
			{
				break;
			}
			catch (ContinueStatement cs)
			{
				//continue;
			}
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
		return "while " + condition + " " + statement;
	}
}
