package com.osh4.ownlang.parser.ast;

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
