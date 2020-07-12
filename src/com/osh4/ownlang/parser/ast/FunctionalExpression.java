package com.osh4.ownlang.parser.ast;

import java.util.ArrayList;
import java.util.List;

import com.osh4.ownlang.lib.Functions;
import com.osh4.ownlang.lib.Value;
import com.osh4.ownlang.lib.Variables;
import com.osh4.ownlang.lib.functions.Function;
import com.osh4.ownlang.lib.functions.UserDefineFunction;

public class FunctionalExpression implements Expression
{
	public final String           name;
	public final List<Expression> args;

	public FunctionalExpression(String name, List<Expression> args)
	{
		this.name = name;
		this.args = args;
	}

	public FunctionalExpression(String name)
	{
		this.name = name;
		this.args = new ArrayList<>();
	}

	public void addArg(Expression arg)
	{
		args.add(arg);
	}

	@Override
	public Value eval()
	{
		final int argSize = args.size();
		final Value[] values = new Value[argSize];
		for (int i = 0; i < argSize; i++)
		{
			values[i] = args.get(i).eval();
		}
		final Function function = Functions.get(name);
		if (function instanceof UserDefineFunction)
		{
			final UserDefineFunction userFunction = (UserDefineFunction) function;
			if (argSize != userFunction.getArgsCount())
			{
				throw new RuntimeException("Args count mismatch");
			}

			Variables.push();
			for (int i = 0; i < argSize; i++)
			{
				Variables.set(userFunction.getArgName(i), values[i]);
			}
			final Value result = userFunction.execute(values);
			Variables.pop();
			return result;
		}
		return function.execute(values);
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return name + "(" + args.toString() + ")";
	}
}
