package com.osh4.ownlang.parser;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.osh4.ownlang.ProgramLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LexerTest
{
	@Test
	public void testLexer()
	{
		final String programText = ProgramLoader.loadFromFile("program.own");
		assertNotNull(programText, "File not loaded");
		final List<Token> tokens = new Lexer(programText).tokenize();
		assertNotNull(tokens, "Gets no token");
		assertEquals(tokens.size(), 31, "Incorrect token count");
		printAllTokens(tokens);
	}

	private void printAllTokens(final List<Token> tokens)
	{
		tokens.forEach(System.out::println);
	}
}
