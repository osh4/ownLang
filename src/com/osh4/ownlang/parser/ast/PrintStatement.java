package com.osh4.ownlang.parser.ast;

public class PrintStatement implements Statement
{
	public final Expression expression;
	public final boolean    hasNewLine;

	public PrintStatement(Expression expression, boolean hasNewLine)
	{
		this.expression = expression;
		this.hasNewLine = hasNewLine;
	}

	@Override
	public void execute()
	{
		System.out.print(expression.eval().asString() + (hasNewLine ? "\n" : ""));
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return (hasNewLine ? "println " : "print ") + expression;
	}
}
