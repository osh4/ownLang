package com.osh4.ownlang.parser.ast;

import com.osh4.ownlang.lib.Value;

public interface Expression extends Node
{
	Value eval();
}
