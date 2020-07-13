package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents break statement in loop.
 */
public final class BreakStatement extends RuntimeException implements Statement
{
	@Override
	public void execute()
	{
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
		return "break";
	}
}
