package com.osh4.ownlang.parser.ast.statement.impl;

import java.util.List;

import com.osh4.ownlang.lib.Functions;
import com.osh4.ownlang.function.impl.UserDefineFunction;
import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents user function definition.
 */
public final class FunctionDefineStatement implements Statement
{
	public final String       name;
	public final List<String> args;
	public final Statement    body;

	/**
	 * Constructor.
	 *
	 * @param name function name
	 * @param args function arguments
	 * @param body function body
	 */
	public FunctionDefineStatement(final String name, final List<String> args, final Statement body)
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
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return "def " + name + "(" + args.toString() + ")\n" + body.toString();
	}
}
