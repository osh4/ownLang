package com.osh4.ownlang.parser.ast.visitor.impl;

import com.osh4.ownlang.parser.ast.expression.impl.ArrayAccessExpression;
import com.osh4.ownlang.parser.ast.expression.impl.ArrayExpression;
import com.osh4.ownlang.parser.ast.expression.impl.BinaryExpression;
import com.osh4.ownlang.parser.ast.expression.impl.ConditionalExpression;
import com.osh4.ownlang.parser.ast.expression.Expression;
import com.osh4.ownlang.parser.ast.expression.impl.FunctionalExpression;
import com.osh4.ownlang.parser.ast.expression.impl.UnaryExpression;
import com.osh4.ownlang.parser.ast.expression.impl.ValueExpression;
import com.osh4.ownlang.parser.ast.expression.impl.VariableExpression;
import com.osh4.ownlang.parser.ast.statement.impl.ArrayAssignmentStatement;
import com.osh4.ownlang.parser.ast.statement.impl.AssignmentStatement;
import com.osh4.ownlang.parser.ast.statement.impl.BlockStatement;
import com.osh4.ownlang.parser.ast.statement.impl.BreakStatement;
import com.osh4.ownlang.parser.ast.statement.impl.ContinueStatement;
import com.osh4.ownlang.parser.ast.statement.impl.DoWhileStatement;
import com.osh4.ownlang.parser.ast.statement.impl.ForStatement;
import com.osh4.ownlang.parser.ast.statement.impl.FunctionDefineStatement;
import com.osh4.ownlang.parser.ast.statement.impl.FunctionStatement;
import com.osh4.ownlang.parser.ast.statement.impl.PrintStatement;
import com.osh4.ownlang.parser.ast.statement.impl.ReturnStatement;
import com.osh4.ownlang.parser.ast.statement.Statement;
import com.osh4.ownlang.parser.ast.statement.impl.WhileStatement;
import com.osh4.ownlang.parser.ast.statement.impl.ifStatement;
import com.osh4.ownlang.parser.ast.visitor.Visitor;

/**
 * Represents abstract visitor.
 */
public abstract class AbstractVisitor implements Visitor
{
	@Override
	public void visit(final ArrayAccessExpression st)
	{
		for (Expression index : st.indices)
		{
			index.accept(this);
		}
	}

	@Override
	public void visit(final ArrayAssignmentStatement st)
	{
		st.array.accept(this);
		st.expression.accept(this);
	}

	@Override
	public void visit(final ArrayExpression st)
	{
		for (Expression element : st.elements)
		{
			element.accept(this);
		}
	}

	@Override
	public void visit(final AssignmentStatement st)
	{
		st.expression.accept(this);
	}

	@Override
	public void visit(final BinaryExpression st)
	{
		st.expr1.accept(this);
		st.expr2.accept(this);
	}

	@Override
	public void visit(final BlockStatement st)
	{
		for (Statement state : st.statementList)
		{
			state.accept(this);
		}
	}

	@Override
	public void visit(final BreakStatement st)
	{

	}

	@Override
	public void visit(final ConditionalExpression st)
	{
		st.expr1.accept(this);
		st.expr2.accept(this);
	}

	@Override
	public void visit(final ContinueStatement st)
	{

	}

	@Override
	public void visit(final DoWhileStatement st)
	{
		st.condition.accept(this);
		st.statement.accept(this);
	}

	@Override
	public void visit(final ForStatement st)
	{
		st.initialization.accept(this);
		st.termination.accept(this);
		st.increment.accept(this);
		st.statement.accept(this);
	}

	@Override
	public void visit(final FunctionalExpression st)
	{
		for (Expression arg : st.args)
		{
			arg.accept(this);
		}
	}

	@Override
	public void visit(final FunctionDefineStatement st)
	{
		st.body.accept(this);
	}

	@Override
	public void visit(final FunctionStatement st)
	{
		st.function.accept(this);
	}

	@Override
	public void visit(final ifStatement st)
	{
		st.expression.accept(this);
		st.ifStatemenet.accept(this);
		if (st.elseStatemenet != null)
		{
			st.elseStatemenet.accept(this);
		}
	}

	@Override
	public void visit(final PrintStatement st)
	{
		st.expression.accept(this);
	}

	@Override
	public void visit(final ReturnStatement st)
	{

	}

	@Override
	public void visit(final UnaryExpression st)
	{
		st.expr1.accept(this);
	}

	@Override
	public void visit(final ValueExpression st)
	{

	}

	@Override
	public void visit(final VariableExpression st)
	{

	}

	@Override
	public void visit(final WhileStatement st)
	{
		st.statement.accept(this);
		st.condition.accept(this);
	}
}

