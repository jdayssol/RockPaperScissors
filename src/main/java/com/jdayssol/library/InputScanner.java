package com.jdayssol.library;

import java.util.Scanner;

/**
 * Singleton scanner for input
 * @author jdayssol
 *
 */
public class InputScanner {

	// use this Scanner in all the code
    private static Scanner scan;
    
    // static method to create instance of Singleton class
    public static Scanner getInstance()
    {
        if (scan == null)
            scan = new Scanner(System.in);
        return scan;
    }
}
