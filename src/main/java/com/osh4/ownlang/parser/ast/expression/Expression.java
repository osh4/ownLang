package com.osh4.ownlang.parser.ast.expression;

import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.visitor.Node;

/**
 * Represents an expression.
 */
public interface Expression extends Node
{
	/**
	 * Evaluates the expression.
	 *
	 * @return Value evaluated
	 */
	Value eval();
}
