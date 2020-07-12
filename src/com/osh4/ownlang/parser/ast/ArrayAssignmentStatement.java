package com.osh4.ownlang.parser.ast;

public class ArrayAssignmentStatement implements Statement
{
	public final ArrayAccessExpression array;
	public final Expression            expression;

	public ArrayAssignmentStatement(ArrayAccessExpression array, Expression expression)
	{
		this.array = array;
		this.expression = expression;
	}

	//arr[4][5][1] = ...

	@Override
	public void execute()
	{
		array.getArray().set(array.lastIndex(), expression.eval());
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", array.toString(), expression);
	}
}
