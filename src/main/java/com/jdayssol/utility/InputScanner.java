package com.jdayssol.utility;

import java.util.Scanner;

/**
 * Utility class to scan for input
 */
public class InputScanner {
    public static Scanner getInstance()
    {
        return new Scanner(System.in);
    }
}
