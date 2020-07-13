package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.lib.Variables;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents value to variable assignment.
 */
public final class AssignmentStatement implements Statement
{
	public final String     variable;
	public final Expression expression;

	/**
	 * Constructor.
	 *
	 * @param variable   variable name
	 * @param expression expression to assign
	 */
	public AssignmentStatement(final String variable, final Expression expression)
	{
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void execute()
	{
		final Value result = expression.eval();
		Variables.set(variable, result);
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", variable, expression);
	}
}
