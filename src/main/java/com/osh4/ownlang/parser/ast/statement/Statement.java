package com.osh4.ownlang.parser.ast.statement;

import com.osh4.ownlang.parser.ast.visitor.Node;

/**
 * Represents statement in ownr language.
 */
public interface Statement extends Node
{
	/**
	 * Executes statement.
	 */
	void execute();
}
