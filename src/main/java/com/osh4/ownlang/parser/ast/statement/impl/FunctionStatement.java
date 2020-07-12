package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.impl.FunctionalExpression;

public class FunctionStatement implements Statement
{
	public final FunctionalExpression function;

	public FunctionStatement(final FunctionalExpression function)
	{
		this.function = function;
	}

	@Override
	public void execute()
	{
		function.eval();
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return function.toString();
	}
}
