package com.osh4.ownlang.parser.visitors;

import com.osh4.ownlang.parser.ast.FunctionDefineStatement;

public class FunctionAdder extends AbstractVisitor
{
	@Override
	public void visit(FunctionDefineStatement st)
	{
		st.body.accept(this);
		st.execute();
	}
}
