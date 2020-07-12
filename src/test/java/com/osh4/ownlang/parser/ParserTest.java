package com.osh4.ownlang.parser;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.osh4.ownlang.ProgramLoader;
import com.osh4.ownlang.parser.ast.statement.impl.BlockStatement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest
{
	private List<Token> tokens;

	@BeforeEach
	public void getTokens()
	{
		final String programText = ProgramLoader.loadFromFile("program.own");
		assertNotNull(programText, "File not loaded");
		tokens = new Lexer(programText).tokenize();
	}

	@Test
	public void testLexer()
	{
		final BlockStatement program = new Parser(tokens).parse();
		assertNotNull(program, "No statements in program");
		assertEquals(program.statementList.size(), 3, "Incorrect statement count");
		System.out.println(program);
	}
}
