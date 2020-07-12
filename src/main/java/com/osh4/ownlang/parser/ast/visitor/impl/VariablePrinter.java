package com.osh4.ownlang.parser.ast.visitor.impl;

import com.osh4.ownlang.parser.ast.statement.impl.AssignmentStatement;
import com.osh4.ownlang.parser.ast.expression.impl.VariableExpression;

/**
 * Represents visitor which prints all the variables defined in program.
 */
public class VariablePrinter extends AbstractVisitor
{
	@Override
	public void visit(final AssignmentStatement st)
	{
		st.expression.accept(this);
		System.out.println(st.variable);
	}

	@Override
	public void visit(final VariableExpression st)
	{
		System.out.println(st.name);
	}
}
