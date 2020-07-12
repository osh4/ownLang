package com.osh4.ownlang.parser.ast;

import com.osh4.ownlang.lib.NumberValue;
import com.osh4.ownlang.lib.StringValue;
import com.osh4.ownlang.lib.Value;

public class ConditionalExpression implements Expression
{

	public enum Operator
	{
		PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), EQUALS("=="), NOT_EQUALS("!="), LT("<"), LTEQ("<="), GT(">"), GTEQ(">="),
		AND("&&"), OR("||");

		private final String name;

		Operator(String name)
		{
			this.name = name;
		}

		public String getName()
		{
			return name;
		}
	}

	public final Expression expr1, expr2;
	public final Operator operation;

	public ConditionalExpression(Operator operation, Expression expr1, Expression expr2)
	{
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operation = operation;
	}

	@Override
	public Value eval()
	{
		final Value value1 = expr1.eval();
		final Value value2 = expr2.eval();

		double number1, number2;
		if (value1 instanceof StringValue)
		{
			number1 = value1.asString().compareTo(value2.asString());
			number2 = 0;
		}
		else
		{
			number1 = value1.asNumber();
			number2 = value2.asNumber();
		}

		boolean result;
		switch (operation)
		{
			case LT:
				result = number1 < number2;
				break;
			case LTEQ:
				result = number1 <= number2;
				break;
			case GT:
				result = number1 > number2;
				break;
			case GTEQ:
				result = number1 >= number2;
				break;
			case NOT_EQUALS:
				result = number1 != number2;
				break;
			case AND:
				result = (number1 != 0 && number2 != 0);
				break;
			case OR:
				result = (number1 != 0 || number2 != 0);
				break;
			case EQUALS:
			default:
				result = number1 == number2;
		}
		return new NumberValue(result);
	}

	@Override
	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public String toString()
	{
		return String.format("[%s %s %s]", expr1, operation.getName(), expr2);
	}
}
