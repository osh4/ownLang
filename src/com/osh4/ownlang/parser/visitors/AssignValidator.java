package com.osh4.ownlang.parser.visitors;

import com.osh4.ownlang.lib.Variables;
import com.osh4.ownlang.parser.ast.AssignmentStatement;

public class AssignValidator extends AbstractVisitor
{
	@Override
	public void visit(AssignmentStatement st)
	{
		st.expression.accept(this);
		if (Variables.isExists(st.variable))
		{
			throw new RuntimeException("Cannot assign value to constant");
		}
	}
}
