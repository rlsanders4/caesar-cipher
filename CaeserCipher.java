/* Author: Ralph Sanders */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaeserCipher {
	public static void main (String[] arg) {
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean done = false;
	while (!done) {
		try {
			boolean invalid = true;
			String operation = "";
			String shift = "";
			String message = "";
			int shiftNum = 0;

			//Determine mode and validate input
			while (invalid) {
				System.out.println("Would you like to encode or decode a message? (enter 'e' or 'd')");
				operation = br.readLine();
				if (operation.equals("e") || operation.equals("d")) {
					invalid = false;
				} else {
					System.out.println("error: Please enter 'e' or 'd'!");
				}
				System.out.println();
			}

			//Determine shift value and validate input
			invalid = true;
			while (invalid) {
				System.out.println("What is the shift value?");
				shift = br.readLine();
				if (shift.matches("\\d+")) {
					shiftNum = Integer.parseInt(shift);
					invalid = false;
				} else {
					System.out.println("error: Please enter a positive integer");
				}
				System.out.println();
			}
			
			//Determine message value
			System.out.println("What is your message?");
			message = br.readLine();
			System.out.println();
			
			//Call encode or decode
			if (operation.equals("e")) {
				encode(alphabet, message, shiftNum);
			} else if (operation.equals("d")) {
				decode(alphabet, message, shiftNum);
			}
			System.out.println();
			
			//Determines if program should run again
			invalid = true;
			while (invalid) {
				System.out.println("Would you like to go again? (enter 'y' or 'n')");
				String isDone = br.readLine();
				if (isDone.equals("y") || isDone.equals("n")) {
					invalid = false;
					if (isDone.equals("n")) {						
						done = true;
						System.out.println("Bye!");
					}
				} else {
					System.out.println("error: Please enter 'y' or 'n'");
					System.out.println();
				}
			}
			System.out.println();


		} catch (Exception e) {
			System.out.println("Input error");
		}
	}
	
	}
	//Encode a message
	private static void encode(String alphabet, String message, int shiftNum) {
		String newMessage = "";
		for (int i = 0; i < message.length(); i++) {
			if (Character.isLetter(message.charAt(i))) {
			   int index = alphabet.indexOf(Character.toLowerCase(message.charAt(i)));
			   index = (index + shiftNum) % 26;
			   newMessage = newMessage + alphabet.charAt(index);
			} else {
				newMessage = newMessage + message.charAt(i);
			}
		}
		System.out.println("Your encoded message is: ");
		System.out.println(newMessage);
	}

	//Decode a message
	private static void decode(String alphabet, String message, int shiftNum) {
		String newMessage = "";
		for (int i = 0; i < message.length(); i++) {
			if (Character.isLetter(message.charAt(i))) {
			   int index = alphabet.indexOf(Character.toLowerCase(message.charAt(i)));
			   index = (26 + index - shiftNum) % 26;
			   newMessage = newMessage + alphabet.charAt(index);
			} else {
				newMessage = newMessage + message.charAt(i);
			}
		}
		System.out.println("Your decoded message is:");
		System.out.println(newMessage);
	}
}