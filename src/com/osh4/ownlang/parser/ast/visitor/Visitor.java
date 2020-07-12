package com.osh4.ownlang.parser.ast.visitor;

import com.osh4.ownlang.parser.ast.expression.impl.ArrayAccessExpression;
import com.osh4.ownlang.parser.ast.expression.impl.ArrayExpression;
import com.osh4.ownlang.parser.ast.expression.impl.BinaryExpression;
import com.osh4.ownlang.parser.ast.expression.impl.ConditionalExpression;
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
import com.osh4.ownlang.parser.ast.statement.impl.WhileStatement;
import com.osh4.ownlang.parser.ast.statement.impl.ifStatement;

/**
 * Visitor.
 */
public interface Visitor
{
	void visit(ArrayAccessExpression st);

	void visit(ArrayAssignmentStatement st);

	void visit(ArrayExpression st);

	void visit(AssignmentStatement st);

	void visit(BinaryExpression st);

	void visit(BlockStatement st);

	void visit(BreakStatement st);

	void visit(ConditionalExpression st);

	void visit(ContinueStatement st);

	void visit(DoWhileStatement st);

	void visit(ForStatement st);

	void visit(FunctionalExpression st);

	void visit(FunctionDefineStatement st);

	void visit(FunctionStatement st);

	void visit(ifStatement st);

	void visit(PrintStatement st);

	void visit(ReturnStatement st);

	void visit(UnaryExpression st);

	void visit(ValueExpression st);

	void visit(VariableExpression st);

	void visit(WhileStatement st);
}
