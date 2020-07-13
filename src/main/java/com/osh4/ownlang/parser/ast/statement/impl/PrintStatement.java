package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.Expression;

/**
 * Represents print to console.
 */
public final class PrintStatement implements Statement
{
	public final Expression expression;
	public final boolean    hasNewLine;

	/**
	 * Constructor.
	 *
	 * @param expression what to print
	 * @param hasNewLine if true use println(), otherwise print()
	 */
	public PrintStatement(final Expression expression, final boolean hasNewLine)
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
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return (hasNewLine ? "println " : "print ") + expression;
	}
}
