package com.osh4.ownlang.parser.ast;

import java.util.List;

import com.osh4.ownlang.lib.Functions;
import com.osh4.ownlang.lib.functions.UserDefineFunction;

public class FunctionDefineStatement implements Statement
{
	public final String       name;
	public final List<String> args;
	public final Statement    body;

	public FunctionDefineStatement(String name, List<String> args, Statement body)
	{
		this.name = name;
		this.args = args;
		this.body = body;
	}

	@Override
	public void execute()
	{
		Functions.set(name, new UserDefineFunction(args, body));
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return "def " + name + "(" + args.toString() + ")\n" + body.toString();
	}
}
