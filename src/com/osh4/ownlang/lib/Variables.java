package com.osh4.ownlang.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.osh4.ownlang.value.impl.NumberValue;
import com.osh4.ownlang.value.Value;

/**
 * Store variables defined in program.
 */
public final class Variables
{
	private static       Map<String, Value>        VARIABLES;
	private static final NumberValue               ZERO = new NumberValue(0);
	private static final Stack<Map<String, Value>> STACK;

	static
	{
		VARIABLES = new HashMap<>();
		VARIABLES.put("PI", new NumberValue(Math.PI));
		VARIABLES.put("E", new NumberValue(Math.E));
		VARIABLES.put("GOLDEN_RATIO", new NumberValue(1.618));
		STACK = new Stack<>();
	}

	/**
	 * Push pool state to the stack.
	 */
	public static void push()
	{
		STACK.push(new HashMap<>(VARIABLES));
	}

	/**
	 * Gets pool state from the stack.
	 */
	public static void pop()
	{
		VARIABLES = STACK.pop();
	}

	/**
	 * Check if variable exists in variable pool.
	 *
	 * @param key variable name as a key
	 *
	 * @return true if variable exists
	 */
	public static boolean isExists(final String key)
	{
		return VARIABLES.containsKey(key);
	}

	/**
	 * Gets variable from function pool.
	 *
	 * @param key variable name
	 *
	 * @return variable Value object
	 */
	public static Value get(final String key)
	{
		if (!isExists(key))
		{
			return ZERO;
		}
		return VARIABLES.get(key);
	}

	/**
	 * Puts variable with value to the pool.
	 *
	 * @param key   variable name as a key
	 * @param value variable value
	 */
	public static void set(final String key, final Value value)
	{
		VARIABLES.put(key, value);
	}

}
