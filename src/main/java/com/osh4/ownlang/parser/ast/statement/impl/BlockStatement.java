package com.osh4.ownlang.parser.ast.statement.impl;

import java.util.ArrayList;
import java.util.List;

import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents block of statements surrounded with braces.
 */
public final class BlockStatement implements Statement
{
	public final List<Statement> statementList;

	/**
	 * Constructor.
	 */
	public BlockStatement()
	{
		this.statementList = new ArrayList<>();
	}

	/**
	 * Adds statement from block to statement list.
	 *
	 * @param statement statement to add
	 */
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
