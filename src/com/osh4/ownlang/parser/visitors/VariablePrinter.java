package com.osh4.ownlang.parser.visitors;

import com.osh4.ownlang.parser.ast.AssignmentStatement;
import com.osh4.ownlang.parser.ast.VariableExpression;

public class VariablePrinter extends AbstractVisitor
{

	@Override
	public void visit(AssignmentStatement st)
	{
		st.expression.accept(this);
		System.out.println(st.variable);
	}

	@Override
	public void visit(VariableExpression st)
	{
		System.out.println(st.name);
	}
}
