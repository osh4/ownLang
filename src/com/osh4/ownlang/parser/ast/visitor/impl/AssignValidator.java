package com.osh4.ownlang.parser.ast.visitor.impl;

import com.osh4.ownlang.lib.Variables;
import com.osh4.ownlang.parser.ast.statement.impl.AssignmentStatement;

/**
 * Represents visitor which checks ability to assign value to variable.
 */
public class AssignValidator extends AbstractVisitor
{
	@Override
	public void visit(final AssignmentStatement st)
	{
		st.expression.accept(this);
		if (Variables.isExists(st.variable))
		{
			throw new RuntimeException("Cannot assign value to constant");
		}
	}
}
