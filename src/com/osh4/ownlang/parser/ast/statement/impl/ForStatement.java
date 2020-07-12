package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.Expression;

public class ForStatement implements Statement
{
	public final Statement  initialization;
	public final Expression termination;
	public final Statement  increment;
	public final Statement  statement;

	public ForStatement(final Statement initialization, final Expression termination, final Statement increment,
	                    final Statement statement)
	{
		this.initialization = initialization;
		this.termination = termination;
		this.increment = increment;
		this.statement = statement;
	}

	@Override
	public void execute()
	{
		for (initialization.execute(); termination.eval().asDouble() != 0; increment.execute())
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
		return "for (" + initialization + "; " + termination + "; " + increment + ") \n{\n" + statement + "}";
	}
}
