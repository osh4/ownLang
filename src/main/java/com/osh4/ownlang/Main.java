package com.osh4.ownlang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import com.osh4.ownlang.parser.Lexer;
import com.osh4.ownlang.parser.Parser;
import com.osh4.ownlang.parser.Token;
import com.osh4.ownlang.parser.ast.statement.impl.BlockStatement;
import com.osh4.ownlang.parser.ast.visitor.impl.AssignValidator;
import com.osh4.ownlang.parser.ast.visitor.impl.FunctionAdder;
import com.osh4.ownlang.parser.ast.visitor.impl.VariablePrinter;

public class Main
{
	public static void main(String[] args)
	{
		//final String fileName = "examples/visitor.own";
		//String fileName = "examples/program.own";
		//String input = Files.readString(Paths.get(fileName));
		if (args.length != 1)
		{
			System.out.println("No program provided");
			return;
		}

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL resource = classloader.getResource(args[0]);

		String programText = null;
		try
		{
			if (resource != null)
			{
				programText = Files.readString(Paths.get(resource.getFile()));
			}
		}
		catch (IOException ignored)
		{
		}

		if (programText == null)
		{
			System.out.println("File is empty or problems with loading");
			return;
		}

		final List<Token> tokens = new Lexer(programText).tokenize();
		final BlockStatement program = new Parser(tokens).parse();

		/*
		for (Token token : tokens)
		{
			System.out.println(token);
		}
				System.out.println(program);
		*/

		program.accept(new FunctionAdder());
		/*program.accept(new VariablePrinter());
		program.accept(new AssignValidator());*/
		program.execute();
	}

}
