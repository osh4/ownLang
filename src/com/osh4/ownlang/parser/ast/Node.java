package com.osh4.ownlang.parser.ast;

public interface Node
{
	void accept(Visitor visitor);
}
