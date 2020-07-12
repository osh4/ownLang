package com.osh4.ownlang.lib.functions;

import com.osh4.ownlang.lib.Value;

public interface Function
{
	Value execute(Value... args);
}
