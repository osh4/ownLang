package com.osh4.ownlang.parser.ast.statement.impl;

import java.util.ArrayList;
import java.util.List;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

public class BlockStatement implements Statement
{
	public final List<Statement> statementList;

	public BlockStatement()
	{
		this.statementList = new ArrayList<>();
	}

	public void add(final Statement statement)
	{
		statementList.add(statement);
	}

	@Override
	public void execute()
	{
		for (Statement statement : statementList)
		{
			statement.execute();
		}
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		final StringBuilder result = new StringBuilder();
		for (Statement statement : statementList)
		{
			result.append(statement.toString()).append(System.lineSeparator());
		}
		return result.toString();
	}
}
