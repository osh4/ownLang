package com.osh4.ownlang.lib;

import java.util.HashMap;
import java.util.Map;

import com.osh4.ownlang.lib.functions.CosFunction;
import com.osh4.ownlang.lib.functions.EchoFunction;
import com.osh4.ownlang.lib.functions.Function;
import com.osh4.ownlang.lib.functions.SinFunction;

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

	public static boolean isExists(String key)
	{
		return FUNCTIONS.containsKey(key);
	}

	public static Function get(String key)
	{
		if (!isExists(key))
		{
			throw new RuntimeException("Unknown function: " + key);
		}
		return FUNCTIONS.get(key);
	}

	public static void set(String key, Function value)
	{
		FUNCTIONS.put(key, value);
	}

}
