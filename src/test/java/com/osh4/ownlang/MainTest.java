package com.osh4.ownlang;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest
{
	private static final String                ADDER = "function";
	private              PrintStream           originalSystemOut;
	private              ByteArrayOutputStream systemOutContent;

	private final static String ARRAYS_RESULT = "[[[0.0, 0.0], [0.0, 0.0]], [[0.0, 0.0], [0.0, 0.0]]]";
	private final static String SUM           = "7.0";

	@DisplayName("Array test")
	@Test
	public void arraysTest()
	{
		Main.main(new String[] {"arrays.own"});
		Assertions.assertEquals(ARRAYS_RESULT, systemOutContent.toString());
	}

	@DisplayName("Math test")
	@Test
	public void mathTest()
	{
		Main.main(new String[] {"math.own"});
		Assertions.assertEquals(SUM, systemOutContent.toString());
	}

	@DisplayName("Function adder test")
	@Test
	public void functionAdderTest()
	{
		Main.main(new String[] {"visitor.own"});
		Assertions.assertEquals(ADDER, systemOutContent.toString());
	}

	@BeforeEach
	void redirectSystemOutStream()
	{
		originalSystemOut = System.out;
		systemOutContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(systemOutContent));
	}

	@AfterEach
	void restoreSystemOutStream()
	{
		System.setOut(originalSystemOut);
	}
}
