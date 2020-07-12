package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

public class DoWhileStatement implements Statement
{
	public final Expression condition;
	public final Statement  statement;

	public DoWhileStatement(final Expression condition, final Statement statement)
	{
		this.condition = condition;
		this.statement = statement;
	}

	@Override
	public void execute()
	{

		do
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
		} while (condition.eval().asDouble() != 0);
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return "do " + statement + " while " + statement;
	}
}
