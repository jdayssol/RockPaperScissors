package com.jdayssol.utility;

import org.junit.Test;

import com.jdayssol.utility.Output;

public class OutputTest {
	@Test
	public void print()
	{
		Output.print("Test %s S %d","d",5);
	}
}
