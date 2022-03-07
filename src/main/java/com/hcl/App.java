package com.hcl;

import java.util.Scanner;

/**
 * Hello world! We need to build a calculator based Command line app where for
 * each operation, it should take 2 numbers and either add, substract, multiply
 * and divide, add
 * 
 * The based application involves prompting the user for 2 number and implement
 * only add
 * 
 * You have to have a menu driven application, where it show a banner and it
 * show "add, substract, multiply, divide" and if you select add or substract,
 * it should prompt for 2 number and the op and do the operation and show the
 * results and keep prompting the user with the same menu.
 * 
 * the 2 key requirement is it should have a basic banner and it should also be
 * menu driven
 * 
 * 
 */
public class App {
	public static void main(String[] args) {
		//Poor mans banner
		System.out.println("The Great 4 Operation Calculator ^.^");
		
		// creates an object of Scanner
	    Scanner input = new Scanner(System.in);
	    boolean go = true;
	    while(go) {
	    	System.out.println("Please enter an operation from this list. +, -, /, *: ");
		    String operation = input.next();
			
		    System.out.print("Enter first number: ");
		    // takes 1st number
		    int firstNumber = input.nextInt();

		    System.out.println("Enter second number: ");
		    // takes 2st number
		    int secondNumber = input.nextInt();

		    
		    if(operation.equals("+")) {
		    	add(firstNumber, secondNumber);
		    }else if(operation.equals("-")) {
		    	subtract(firstNumber, secondNumber);
		    }else if(operation.equals("/")) {
		    	divide(firstNumber, secondNumber);
		    }else if(operation.equals("*")) {
		    	multiply(firstNumber, secondNumber);
		    }else {
		    	System.out.println("Invalid operation entered.");
		    }
		    
		    System.out.println("Would you like to do another operation? input Y or N: ");
		    boolean gogo = true;
		    while(gogo) {
		    	String repeat = input.next();
			    if(repeat.toUpperCase().equals("Y")) {
			    	gogo = false;
			    }else if(repeat.toUpperCase().equals("N")) {
			    	go = false;
			    	gogo = false;
			    }else {
			    	System.out.println("invalid input, try again. input Y or N: ");	    	
			    }
		    }
		    
	    }

	    // closes the scanner
	    input.close();
	}
	
	public static void add(int firstNumber, int secondNumber) {
		//operation add only
	    int sum = firstNumber + secondNumber;
	    
	    System.out.printf("Sum of %d and %d = %d %n", firstNumber, secondNumber, sum);
	}
	
	public static void subtract(int firstNumber, int secondNumber) {
		//operation add only
	    int difference = firstNumber - secondNumber;
	    
	    System.out.printf("Difference of %d and %d = %d %n", firstNumber, secondNumber, difference);
	}
	
	public static void divide(int firstNumber, int secondNumber) {
		//operation add only
	    int quotient = firstNumber / secondNumber;
	    
	    System.out.printf("Quotient of %d and %d = %d %n", firstNumber, secondNumber, quotient);
	}
	
	public static void multiply(int firstNumber, int secondNumber) {
		//operation add only
	    int product = firstNumber * secondNumber;
	    
	    System.out.printf("Product of %d and %d = %d %n", firstNumber, secondNumber, product);
	}
	
	
	
}
