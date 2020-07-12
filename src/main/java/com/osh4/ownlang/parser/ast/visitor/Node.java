package com.osh4.ownlang.parser.ast.visitor;

/**
 * Represents node which accepts visitor.
 */
public interface Node
{
	/**
	 * Accept visitor by node.
	 */
	void accept(Visitor visitor);
}
