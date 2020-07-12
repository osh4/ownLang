package com.osh4.ownlang.parser;

public enum TokenType
{
	NUMBER,
	HEX_NUMBER,
	WORD,
	TEXT,

	//keyword
	PRINT,
	PRINTLN,
	IF,
	ELSE,
	WHILE,
	FOR,
	DO,
	BREAK,
	CONTINUE,
	DEF,
	RETURN,

	PLUS, MINUS,
	STAR, SLASH,
	EQ, //=
	EQEQ,
	LTEQ,
	GTEQ,
	EXCL,
	EXCLEQ,
	BAR,
	BARBAR,
	AMP,
	AMPAMP,
	LT,
	GT,

	LPAREN, //(
	RPAREN, //)
	LBRACE, //{
	RBRACE, //}
	SEMICOLON,  //;
	COMMA,  //,
	RBRACKET, //[
	LBRACKET, //]

	EOF
}
