package com.osh4.ownlang.parser.ast;

public class BreakStatement extends RuntimeException implements Statement
{
	@Override
	public void execute()
	{
		throw this;
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return "break";
	}
}
