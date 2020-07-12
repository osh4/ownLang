package com.osh4.ownlang.parser.visitors;

import com.osh4.ownlang.parser.ast.*;

public abstract class AbstractVisitor implements Visitor
{
	@Override
	public void visit(ArrayAccessExpression st)
	{
		for (Expression index : st.indices)
		{
			index.accept(this);
		}
	}

	@Override
	public void visit(ArrayAssignmentStatement st)
	{
		st.array.accept(this);
		st.expression.accept(this);
	}

	@Override
	public void visit(ArrayExpression st)
	{
		for (Expression element : st.elements)
		{
			element.accept(this);
		}
	}

	@Override
	public void visit(AssignmentStatement st)
	{
		st.expression.accept(this);
	}

	@Override
	public void visit(BinaryExpression st)
	{
		st.expr1.accept(this);
		st.expr2.accept(this);
	}

	@Override
	public void visit(BlockStatement st)
	{
		for (Statement state : st.statementList)
		{
			state.accept(this);
		}
	}

	@Override
	public void visit(BreakStatement st)
	{

	}

	@Override
	public void visit(ConditionalExpression st)
	{
		st.expr1.accept(this);
		st.expr2.accept(this);
	}

	@Override
	public void visit(ContinueStatement st)
	{

	}

	@Override
	public void visit(DoWhileStatement st)
	{
		st.condition.accept(this);
		st.statement.accept(this);
	}

	@Override
	public void visit(ForStatement st)
	{
		st.initialization.accept(this);
		st.termination.accept(this);
		st.increment.accept(this);
		st.statement.accept(this);
	}

	@Override
	public void visit(FunctionalExpression st)
	{
		for (Expression arg : st.args)
		{
			arg.accept(this);
		}
	}

	@Override
	public void visit(FunctionDefineStatement st)
	{
		st.body.accept(this);
	}

	@Override
	public void visit(FunctionStatement st)
	{
		st.function.accept(this);
	}

	@Override
	public void visit(ifStatement st)
	{
		st.expression.accept(this);
		st.ifStatemenet.accept(this);
		if (st.elseStatemenet != null)
		{
			st.elseStatemenet.accept(this);
		}
	}

	@Override
	public void visit(PrintStatement st)
	{
		st.expression.accept(this);
	}

	@Override
	public void visit(ReturnStatement st)
	{

	}

	@Override
	public void visit(UnaryExpression st)
	{
		st.expr1.accept(this);
	}

	@Override
	public void visit(ValueExpression st)
	{

	}

	@Override
	public void visit(VariableExpression st)
	{

	}

	@Override
	public void visit(WhileStatement st)
	{
		st.statement.accept(this);
		st.condition.accept(this);
	}
}

