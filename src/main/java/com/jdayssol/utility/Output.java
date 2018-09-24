package com.jdayssol.utility;

/**
 * Utility class to outsource the print of the program
 * @author jdayssol
 *
 */
public class Output {

	public static void print(String toPrint,Object... args)
	{
		System.out.printf(toPrint+"%n",args);
	}
	
	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}
}
