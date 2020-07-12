package com.osh4.ownlang;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.osh4.ownlang.parser.Lexer;
import com.osh4.ownlang.parser.Parser;
import com.osh4.ownlang.parser.Token;
import com.osh4.ownlang.parser.ast.BlockStatement;
import com.osh4.ownlang.parser.visitors.AssignValidator;
import com.osh4.ownlang.parser.visitors.FunctionAdder;
import com.osh4.ownlang.parser.visitors.VariablePrinter;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		final String fileName = "examples/visitor.own";
		//String fileName = "examples/program.own";
		String input = Files.readString(Paths.get(fileName));
		final List<Token> tokens = new Lexer(input).tokenize();
		for (Token token : tokens)
		{
			System.out.println(token);
		}

		BlockStatement program = new Parser(tokens).parse();

		System.out.println(program);

		program.accept(new FunctionAdder());
		program.accept(new VariablePrinter());
		program.accept(new AssignValidator());
		program.execute();
	}
}
