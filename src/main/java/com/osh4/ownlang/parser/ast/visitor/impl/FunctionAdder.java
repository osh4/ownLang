package com.osh4.ownlang.parser.ast.visitor.impl;

import com.osh4.ownlang.parser.ast.statement.impl.FunctionDefineStatement;

/**
 * Represents visitor which add all functions declared from program before program execution.
 */
public class FunctionAdder extends AbstractVisitor
{
	@Override
	public void visit(final FunctionDefineStatement st)
	{
		st.body.accept(this);
		st.execute();
	}
}
