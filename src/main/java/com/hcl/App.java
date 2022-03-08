package com.hcl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
		// Poor mans banner
		System.out.println("The Great 4 Operation Calculator ^.^");

		// create File
		File myObj = new File("operationsList.txt");
		try {
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// creates an object of Scanner
		Scanner input = new Scanner(System.in);

		// main menu
		boolean menu = true;
		while (menu) {
			System.out.println("Please enter an option from this list. Operate, View, Quit: ");
			String option = input.next();

			switch (option.toLowerCase()) {
			case "operate":
				boolean go = true;
				while (go) {
					System.out.println("Please enter an operation from this list. +, -, /, *: ");
					String operation = input.next();

					System.out.print("Enter first number: ");
					// takes 1st number
					int firstNumber = input.nextInt();

					System.out.println("Enter second number: ");
					// takes 2st number
					int secondNumber = input.nextInt();

					int result = 0;
					switch (operation) {
					case "+":
						result = add(firstNumber, secondNumber);
						write(operation, firstNumber, secondNumber, result);
						break;
					case "-":
						result = subtract(firstNumber, secondNumber);
						write(operation, firstNumber, secondNumber, result);
						break;
					case "/":
						result = divide(firstNumber, secondNumber);
						write(operation, firstNumber, secondNumber, result);
						break;
					case "*":
						result = multiply(firstNumber, secondNumber);
						write(operation, firstNumber, secondNumber, result);
						break;
					default:
						System.out.println("Invalid operation entered.");
						break;
					}

					// loops operation menu
					System.out.println("Would you like to do another operation? input Y or N: ");
					boolean gogo = true;
					while (gogo) {
						String repeat = input.next();
						if (repeat.toUpperCase().equals("Y")) {
							gogo = false;
						} else if (repeat.toUpperCase().equals("N")) {
							go = false;
							gogo = false;
						} else {
							System.out.println("invalid input, try again. input Y or N: ");
						}
					}
				}
				break;
			case "view":
				try {
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						System.out.println(data);
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				break;
			case "quit":
				break;
			default:
				System.out.println("Invalid option entered.");
				break;
			}

			// loops main menu
			System.out.println("Would you like to do anything else? input Y or N: ");
			boolean menuBoolean = true;
			while (menuBoolean) {
				String repeat2 = input.next();
				if (repeat2.toUpperCase().equals("Y")) {
					menuBoolean = false;
				} else if (repeat2.toUpperCase().equals("N")) {
					menu = false;
					menuBoolean = false;
				} else {
					System.out.println("invalid input, try again. input Y or N: ");
				}
			}

		}

		// closes the scanner
		input.close();
	}

	public static void write(String operation, int firstNumber, int secondNumber, int result) {
		try {
			FileWriter myWriter = new FileWriter("operationsList.txt", true);
			myWriter.write(operation + "," + firstNumber + "," + secondNumber + "," + result
					+ System.getProperty("line.separator"));
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static int add(int firstNumber, int secondNumber) {
		// operation add only
		int sum = firstNumber + secondNumber;

		System.out.printf("Sum of %d and %d = %d %n", firstNumber, secondNumber, sum);
		return sum;
	}

	public static int subtract(int firstNumber, int secondNumber) {
		// operation add only
		int difference = firstNumber - secondNumber;

		System.out.printf("Difference of %d and %d = %d %n", firstNumber, secondNumber, difference);
		return difference;
	}

	public static int divide(int firstNumber, int secondNumber) {
		// operation add only
		int quotient = firstNumber / secondNumber;

		System.out.printf("Quotient of %d and %d = %d %n", firstNumber, secondNumber, quotient);
		return quotient;
	}

	public static int multiply(int firstNumber, int secondNumber) {
		// operation add only
		int product = firstNumber * secondNumber;

		System.out.printf("Product of %d and %d = %d %n", firstNumber, secondNumber, product);
		return product;
	}

}
