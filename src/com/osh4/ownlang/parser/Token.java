package com.osh4.ownlang.parser;

/**
 * Token.
 */
public final class Token
{
	private TokenType type;
	private String text; // "4.567", "var1"

	/**
	 * Constructor.
	 *
	 * @param type token type
	 * @param text token content
	 */
	public Token(final TokenType type, final String text)
	{
		this.type = type;
		this.text = text;
	}

	/**
	 * Token type getter.
	 *
	 * @return token type
	 */
	public TokenType getType()
	{
		return type;
	}

	/**
	 * Token type setter.
	 *
	 * @param type token type
	 */
	public void setType(final TokenType type)
	{
		this.type = type;
	}

	/**
	 * Text getter.
	 *
	 * @return token content
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Token content setter.
	 *
	 * @param text token content
	 */
	public void setText(final String text)
	{
		this.text = text;
	}

	@Override
	public String toString()
	{
		return "[" + type + "]: " + text;
	}
}
