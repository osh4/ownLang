package com.osh4.ownlang.parser.ast;

import com.osh4.ownlang.lib.Value;
import com.osh4.ownlang.lib.Variables;

public class VariableExpression implements Expression
{
	public final String name;

	public VariableExpression(String name)
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
