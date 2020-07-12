package com.osh4.ownlang.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Split program into tokens.
 */
public final class Lexer
{
	private static final String                 OPERATOR_CHARS = "+-*/(){}=<>!&|;[],";
	private static final Map<String, TokenType> OPERATORS;

	static
	{
		OPERATORS = new HashMap<>();
		OPERATORS.put("+", TokenType.PLUS);
		OPERATORS.put("-", TokenType.MINUS);
		OPERATORS.put("*", TokenType.STAR);
		OPERATORS.put("/", TokenType.SLASH);

		OPERATORS.put("(", TokenType.LPAREN);
		OPERATORS.put(")", TokenType.RPAREN);
		OPERATORS.put("{", TokenType.LBRACE);
		OPERATORS.put("}", TokenType.RBRACE);
		OPERATORS.put("[", TokenType.LBRACKET);
		OPERATORS.put("]", TokenType.RBRACKET);
		OPERATORS.put(";", TokenType.SEMICOLON);
		OPERATORS.put(",", TokenType.COMMA);

		OPERATORS.put("=", TokenType.EQ);
		OPERATORS.put("<", TokenType.LT);
		OPERATORS.put(">", TokenType.GT);

		OPERATORS.put("!", TokenType.EXCL);
		OPERATORS.put("&", TokenType.AMP);
		OPERATORS.put("|", TokenType.BAR);

		OPERATORS.put("==", TokenType.EQEQ);
		OPERATORS.put("!=", TokenType.EXCLEQ);
		OPERATORS.put("<=", TokenType.LTEQ);
		OPERATORS.put(">=", TokenType.GTEQ);

		OPERATORS.put("&&", TokenType.AMPAMP);
		OPERATORS.put("||", TokenType.BARBAR);
	}

	private final String      input;
	private final List<Token> tokens;
	private       int         pos;
	private final int         length;

	/**
	 * Constructor.
	 *
	 * @param input program text
	 */
	public Lexer(final String input)
	{
		this.input = input;
		this.length = input.length();
		tokens = new ArrayList<>();
	}

	/**
	 * Tokenize program.
	 *
	 * @return list of token
	 */
	public List<Token> tokenize()
	{
		while (pos < length)
		{
			final char current = peek(0);
			if (Character.isDigit(current))
			{
				tokenizeNumber();
			}
			else if (Character.isLetter(current))
			{
				tokenizeWord();
			}
			else if (current == '#')
			{
				next();
				tokenizeHexNumber();
			}
			else if (current == '"')
			{
				tokenizeText();
			}
			else if (OPERATOR_CHARS.indexOf(current) != -1)
			{
				tokenizeOperator();
			}
			else
			{
				//whitespaces
				next();
			}
		}
		return tokens;
	}

	private void tokenizeText()
	{
		next(); //skip "
		final StringBuilder buffer = new StringBuilder();
		char current = peek(0);
		while (true)
		{
			if (current == '\\')
			{
				current = next();
				switch (current)
				{
					case '"':
						current = next();
						buffer.append('"');
						continue;
					case 'n':
						current = next();
						buffer.append('\n');
						continue;
					case 't':
						current = next();
						buffer.append('\t');
						continue;
				}
				buffer.append("\\");
				continue;
			}
			if (current == '"')
			{
				break;
			}
			buffer.append(current);
			current = next();
		}
		next(); //skip closing "

		addToken(TokenType.TEXT, buffer.toString());
	}

	private void tokenizeWord()
	{
		final StringBuilder buffer = new StringBuilder();
		char current = peek(0);
		while (Character.isLetterOrDigit(current) || current == '_' || current == '$')
		{
			buffer.append(current);
			current = next();
		}

		String word = buffer.toString();
		switch (word.toLowerCase())
		{
			case "print":
				addToken(TokenType.PRINT);
				break;
			case "println":
				addToken(TokenType.PRINTLN);
				break;
			case "if":
				addToken(TokenType.IF);
				break;
			case "else":
				addToken(TokenType.ELSE);
				break;
			case "while":
				addToken(TokenType.WHILE);
				break;
			case "for":
				addToken(TokenType.FOR);
				break;
			case "do":
				addToken(TokenType.DO);
				break;
			case "break":
				addToken(TokenType.BREAK);
				break;
			case "continue":
				addToken(TokenType.CONTINUE);
				break;
			case "def":
				addToken(TokenType.DEF);
				break;
			case "return":
				addToken(TokenType.RETURN);
				break;
			default:
				addToken(TokenType.WORD, word);
		}
	}

	private void tokenizeHexNumber()
	{
		final StringBuilder buffer = new StringBuilder();
		char current = peek(0);
		while (isHexNumber(current))
		{
			buffer.append(current);
			current = next();
		}
		addToken(TokenType.HEX_NUMBER, buffer.toString());
	}

	private boolean isHexNumber(final char current)
	{
		return Character.isDigit(current) || "abcdef".indexOf(Character.toLowerCase(current)) != -1;
	}

	private void tokenizeOperator()
	{
		char current = peek(0);
		if (current == '/')
		{
			if (peek(1) == '/')
			{
				next();
				next();
				tokenizeComment();
				return;
			}
			else if (peek(1) == '*')
			{
				next();
				next();
				tokenizeMultilineComment();
				return;
			}
		}
		final StringBuilder buffer = new StringBuilder();
		while (true)
		{
			final String text = buffer.toString();
			if (!OPERATORS.containsKey(text + current) && !text.isEmpty())
			{
				addToken(OPERATORS.get(text));
				return;
			}
			buffer.append(current);
			current = next();
		}
	}

	private void tokenizeMultilineComment()
	{
		char current = peek(0);
		while (true)
		{
			if (current == '\0')
			{
				throw new RuntimeException("Missing close tag");
			}
			if (current == '*' && peek(1) == '/')
			{
				break;
			}
			current = next();
		}
		next(); //*
		next(); ///
	}

	private void tokenizeComment()
	{
		char current = peek(0);
		while ("\r\n\0".indexOf(current) == -1)
		{
			current = next();
		}
	}

	private void tokenizeNumber()
	{
		final StringBuilder buffer = new StringBuilder();
		char current = peek(0);
		while (true)
		{
			if (current == '.')
			{
				if (buffer.indexOf(".") != -1)
				{
					throw new RuntimeException("Invalid float number");
				}
			}
			else if (!Character.isDigit(current))
			{
				break;
			}
			buffer.append(current);
			current = next();
		}

		addToken(TokenType.NUMBER, buffer.toString());
	}

	private char peek(final int relativePosition)
	{
		final int position = pos + relativePosition;
		if (position >= length)
		{
			return '\0';
		}
		return input.charAt(position);
	}

	private char next()
	{
		pos++;
		return peek(0);
	}

	private void addToken(final TokenType type)
	{
		addToken(type, "");
	}

	private void addToken(final TokenType type, final String text)
	{
		tokens.add(new Token(type, text));
	}

}
