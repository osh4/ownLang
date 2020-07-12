package com.osh4.ownlang.lib.functions;

import java.util.List;

import com.osh4.ownlang.lib.NumberValue;
import com.osh4.ownlang.lib.Value;
import com.osh4.ownlang.parser.ast.ReturnStatement;
import com.osh4.ownlang.parser.ast.Statement;

public final class UserDefineFunction implements Function
{
	private final List<String> args;
	private final Statement    body;

	public UserDefineFunction(List<String> args, Statement body)
	{
		this.args = args;
		this.body = body;
	}

	public int getArgsCount()
	{
		return args.size();
	}

	public String getArgName(int index)
	{
		if (index < 0 || index >= getArgsCount())
		{
			return "";
		}
		return args.get(index);
	}

	@Override
	public Value execute(Value... args)
	{
		try
		{
			body.execute();
			return NumberValue.ZERO;
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
