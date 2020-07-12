package com.osh4.ownlang.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class Variables
{
	private static       Map<String, Value>        VARIABLES;
	private static final NumberValue               ZERO = new NumberValue(0);
	private static final Stack<Map<String, Value>> stack;

	static
	{
		VARIABLES = new HashMap<>();
		VARIABLES.put("PI", new NumberValue(Math.PI));
		VARIABLES.put("ПИ", new NumberValue(Math.PI));
		VARIABLES.put("E", new NumberValue(Math.E));
		VARIABLES.put("GOLDEN_RATIO", new NumberValue(1.618));
		stack = new Stack<>();
	}

	public static void push()
	{
		stack.push(new HashMap<>(VARIABLES));
	}

	public static void pop()
	{
		VARIABLES = stack.pop();
	}

	public static boolean isExists(String key)
	{
		return VARIABLES.containsKey(key);
	}

	public static Value get(String key)
	{
		if (!isExists(key))
		{
			return ZERO;
		}
		return VARIABLES.get(key);
	}

	public static void set(String key, Value value)
	{
		VARIABLES.put(key, value);
	}

}
