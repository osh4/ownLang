package com.osh4.ownlang.function.impl;

import java.util.List;

import com.osh4.ownlang.function.Function;
import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.statement.impl.ReturnStatement;
import com.osh4.ownlang.parser.ast.statement.Statement;

/**
 * Process user define function/method.
 */
public final class UserDefineFunction implements Function
{
	private final List<String> args;
	private final Statement    body;

	public UserDefineFunction(final List<String> args, final Statement body)
	{
		this.args = args;
		this.body = body;
	}

	public int getArgsCount()
	{
		return args.size();
	}

	public String getArgName(final int index)
	{
		if (index < 0 || index >= getArgsCount())
		{
			return "";
		}
		return args.get(index);
	}

	@Override
	public Value execute(final Value... args)
	{
		try
		{
			body.execute();
			return Value.ZERO;
		}
		catch (ReturnStatement ex)
		{
			return ex.getResult();
		}
	}

	@Override
	public String toString()
	{
		return "UserDefineFunction{}";
	}
}
