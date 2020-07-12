package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.Expression;

public class ReturnStatement extends RuntimeException implements Statement
{
	public final Expression expression;
	public       Value      result;

	public ReturnStatement(final Expression expression)
	{
		this.expression = expression;
	}

	public Value getResult()
	{
		return result;
	}

	@Override
	public void execute()
	{
		result = expression.eval();
		throw this;
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return "return";
	}
}
