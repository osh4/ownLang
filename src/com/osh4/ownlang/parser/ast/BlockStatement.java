package com.osh4.ownlang.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class BlockStatement implements Statement
{
	public final List<Statement> statementList;

	public BlockStatement()
	{
		this.statementList = new ArrayList<>();
	}

	public void add(Statement statement)
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
	public void accept(Visitor visitor)
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
