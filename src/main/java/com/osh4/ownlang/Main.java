package com.osh4.ownlang;

import java.util.List;

import com.osh4.ownlang.parser.Lexer;
import com.osh4.ownlang.parser.Parser;
import com.osh4.ownlang.parser.Token;
import com.osh4.ownlang.parser.ast.statement.impl.BlockStatement;
import com.osh4.ownlang.parser.ast.visitor.impl.FunctionAdder;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("No program provided");
			return;
		}

		String programText = ProgramLoader.loadFromFile(args[0]);
		if (programText == null)
		{
			return;
		}
		final List<Token> tokens = new Lexer(programText).tokenize();
		final BlockStatement program = new Parser(tokens).parse();

		program.accept(new FunctionAdder());
		program.execute();
	}

}
