package com.hcl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	public static void main(String[] args) throws IOException {
		// Poor mans banner
		System.out.println("The Great 4 Operation Calculator ^.^");
		List<String> opList = new ArrayList<String>(Arrays.asList("+","-","*","/"));

		// create file
		File myObj = createFile();

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
					double firstNumber = 0;
					double secondNumber = 0;				

					if(opList.contains(operation)) {
						System.out.print("Enter first number: ");
						// takes 1st number
						firstNumber = input.nextDouble();

						System.out.println("Enter second number: ");
						// takes 2st number
						secondNumber = input.nextDouble();
					}
					
					double result = 0;
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

					go = menuOperator(input, go,"Would you like to do another operation? input Y or N: ");
					if(!go) {
						// loops main menu
						menu = menuOperator(input, menu,"Would you like to do anything else? input Y or N: ");
					}
				}
				break;
			case "view":
				viewFile(myObj);
				// loops main menu
				menu = menuOperator(input, menu,"Would you like to do anything else? input Y or N: ");
				break;
			case "quit":
				menu = false;
				break;
			default:
				System.out.println("Invalid option entered.");
				// loops main menu
				menu = menuOperator(input, menu,"Would you like to do anything else? input Y or N: ");
				break;
			}
		}
		// closes the scanner
		input.close();
	}

	private static boolean menuOperator(Scanner input, boolean go, String message) {
		// loops operation menu
		System.out.println(message);
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
		return go;
	}

	private static File createFile() {
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
		return myObj;
	}

	private static void viewFile(File myObj) throws FileNotFoundException {
		try (Scanner myReader = new Scanner(myObj);) {
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
		} 
	}

	public static void write(String operation, double firstNumber, double secondNumber, double result) throws IOException {
		try (FileWriter myWriter = new FileWriter("operationsList.txt", true);) {
			myWriter.write(operation + "," + firstNumber + "," + secondNumber + "," + result
					+ System.getProperty("line.separator"));
			System.out.println("Successfully wrote to the file.");
		}
	}

	public static double add(double firstNumber, double secondNumber) {
		// operation add only
		double sum = firstNumber + secondNumber;

		System.out.printf("Sum of %f and %f = %f %n", firstNumber, secondNumber, sum);
		return sum;
	}

	public static double subtract(double firstNumber, double secondNumber) {
		// operation add only
		double difference = firstNumber - secondNumber;

		System.out.printf("Difference of %f and %f = %f %n", firstNumber, secondNumber, difference);
		return difference;
	}

	public static double divide(double firstNumber, double secondNumber) {
		// operation add only
		double quotient = firstNumber / secondNumber;

		System.out.printf("Quotient of %f and %f = %f %n", firstNumber, secondNumber, quotient);
		return quotient;
	}

	public static double multiply(double firstNumber, double secondNumber) {
		// operation add only
		double product = firstNumber * secondNumber;

		System.out.printf("Product of %f and %f = %f %n", firstNumber, secondNumber, product);
		return product;
	}

}
