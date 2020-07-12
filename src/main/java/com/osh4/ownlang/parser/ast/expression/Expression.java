package com.osh4.ownlang.parser.ast.expression;

import com.osh4.ownlang.value.Value;
import com.osh4.ownlang.parser.ast.visitor.Node;

public interface Expression extends Node
{
	Value eval();
}
