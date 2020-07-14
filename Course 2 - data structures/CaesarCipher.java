import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String[] args) {
		//call methods for test
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter message to be encrypted:");
		String message = scan.nextLine();
		System.out.print("\nEnter key for encryption:");
		int key = scan.nextInt();
		String encryption = encrypt(message, key);
		System.out.println(encryption);
		String decryption = encrypt(encryption, 26-key);
		System.out.println(decryption);
	}

	//method for encrypting message
	public static String encrypt(String message, int key) {
		//make StringBuilder from message to easily modify String
		StringBuilder encryption = new StringBuilder(message);
		//Set base alphabet for conversion
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//Shift alphabet to get encrypted letter
		String shiftAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		//Keep track if character is lowercase or not
		boolean isLower = false;
		//loop through message and switch characters
		for(int i = 0; i < encryption.length(); i++) {
			//get current character
			char currChar = encryption.charAt(i);
			//check if lower case
			isLower = Character.isLowerCase(currChar);
			//make currChar uppercase to search in alphabet string
			currChar = Character.toUpperCase(currChar);
			//get index of currChar in alphabet
			int index = alphabet.indexOf(currChar);
			//if found, switch for encrypted character
			if(index != -1) {
				char newChar = shiftAlphabet.charAt(index);
				if(isLower)
					newChar = Character.toLowerCase(newChar);
				encryption.setCharAt(i, newChar);
			}
		}

		return encryption.toString();
	}
}
