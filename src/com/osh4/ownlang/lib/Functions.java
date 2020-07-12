package com.osh4.ownlang.lib;

import java.util.HashMap;
import java.util.Map;

import com.osh4.ownlang.function.impl.CosFunction;
import com.osh4.ownlang.function.impl.EchoFunction;
import com.osh4.ownlang.function.Function;
import com.osh4.ownlang.function.impl.NewarrayFunction;
import com.osh4.ownlang.function.impl.SinFunction;

/**
 * Store functions defined in program inside the pool.
 */
public final class Functions
{
	private static final Map<String, Function> FUNCTIONS;

	static
	{
		FUNCTIONS = new HashMap<>();
		FUNCTIONS.put("sin", args -> new SinFunction().execute(args));
		FUNCTIONS.put("cos", args -> new CosFunction().execute(args));
		FUNCTIONS.put("echo", args -> (new EchoFunction()).execute(args));
		FUNCTIONS.put("newarray", args -> (new NewarrayFunction()).execute(args));
	}

	/**
	 * Check if function exists in function pool.
	 *
	 * @param key function name as a key
	 *
	 * @return true if function exists
	 */
	public static boolean isExists(final String key)
	{
		return FUNCTIONS.containsKey(key);
	}

	/**
	 * Gets function from function pool.
	 *
	 * @param key function name
	 *
	 * @return Function object
	 */
	public static Function get(final String key)
	{
		if (!isExists(key))
		{
			throw new RuntimeException("Unknown function: " + key);
		}
		return FUNCTIONS.get(key);
	}

	/**
	 * Puts function to the function pool.
	 *
	 * @param key   function name as a key
	 * @param value function body as Function object
	 */
	public static void set(final String key, final Function value)
	{
		FUNCTIONS.put(key, value);
	}

}
