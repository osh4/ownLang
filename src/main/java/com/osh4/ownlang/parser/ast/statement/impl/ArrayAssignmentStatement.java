package com.osh4.ownlang.parser.ast.statement.impl;

import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;
import com.osh4.ownlang.parser.ast.expression.impl.ArrayAccessExpression;

/**
 * Represents value to array element assignment.
 */
public final class ArrayAssignmentStatement implements Statement
{
	public final ArrayAccessExpression array;
	public final Expression            expression;

	/**
	 * Constructor.
	 *
	 * @param array      array to operate with
	 * @param expression expression to assign
	 */
	public ArrayAssignmentStatement(final ArrayAccessExpression array, final Expression expression)
	{
		this.array = array;
		this.expression = expression;
	}

	@Override
	public void execute()
	{
		array.getArray().set(array.lastIndex(), expression.eval());
	}

	@Override
	public void accept(final Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", array.toString(), expression);
	}
}
