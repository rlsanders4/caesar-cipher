/* Author: Ralph Sanders */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaeserCipher {
	public static void main (String[] arg) {
	String alphabet = "abcdefghijklmnopqrstuvwzyz";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Would you like to encode or decode a message? (enter 'e' or 'd')");
	try {
		String operation = br.readLine();
		System.out.println("What is the shift value?");
		String shift = br.readLine();
		int shiftNum = Integer.parseInt(shift);
		System.out.println("What is your message?");
		String message = br.readLine();

		if (operation.equals("e")) {
			encode(alphabet, message, shiftNum);
		} else if (operation.equals("d")) {
			decode(alphabet, message, shiftNum);
		}


	} catch (Exception e) {
		System.out.println("Input error");
	}
	
	}

	private static void encode(String alphabet, String message, int shiftNum) {
		String newMessage = "";
		for (int i = 0; i < message.length(); i++) {
			if (Character.isLetter(message.charAt(i))) {
			   int index = alphabet.indexOf(message.charAt(i));
			   index = index + shiftNum;
			   newMessage = newMessage + alphabet.charAt(index);
			} else {
				newMessage = newMessage + message.charAt(i);
			}
		}
		System.out.println("Your encoded message is: ");
		System.out.println(newMessage);
	}

	private static void decode(String alphabet, String message, int shiftNum) {
		String newMessage = "";
		for (int i = 0; i < message.length(); i++) {
			if (Character.isLetter(message.charAt(i))) {
			   int index = alphabet.indexOf(message.charAt(i));
			   index = index - shiftNum;
			   newMessage = newMessage + alphabet.charAt(index);
			} else {
				newMessage = newMessage + message.charAt(i);
			}
		}
		System.out.println("Your decoded message is:");
		System.out.println(newMessage);
	}
}