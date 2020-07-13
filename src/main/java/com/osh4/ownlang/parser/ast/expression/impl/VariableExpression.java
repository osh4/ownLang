package com.osh4.ownlang.parser.ast.expression.impl;

import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.lib.Variables;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents variable definition.
 */
public final class VariableExpression implements Expression
{
	public final String name;

	/**
	 * Constructor.
	 *
	 * @param name variable name
	 */
	public VariableExpression(final String name)
	{
		this.name = name;
	}

	@Override
	public Value eval()
	{
		if (!Variables.isExists(name))
		{
			throw new RuntimeException("Constant does not exists");
		}
		return Variables.get(name);
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return String.format("%s", name);
	}
}
