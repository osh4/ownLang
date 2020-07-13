package com.osh4.ownlang.parser.ast.visitor;

/**
 * Represents node which accepts visitor.
 */
public interface Node
{
	/**
	 * Accept visitor by node.
	 *
	 * @param visitor visitor
	 */
	void accept(Visitor visitor);
}
