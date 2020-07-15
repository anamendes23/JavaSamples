import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String[] args) {
		//call methods for test
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter message to be encrypted:");
		String message = scan.nextLine();
		System.out.print("\nEnter key for encryption:");
		int key = scan.nextInt();
		scan.nextLine();
		String encryption = encrypt(message, key);
		System.out.println(encryption);
		String decryption = encrypt(encryption, 26-key);
		System.out.println(decryption);

		//test encryption with two keys
		System.out.print("\n\nTesting encryption with two keys:");
		System.out.println("\nEnter message to be encrypted:");
		String message1 = scan.nextLine();
		System.out.print("\nEnter key1 for encryption:");
		int key1 = scan.nextInt();
		System.out.print("\nEnter key2 for encryption:");
		int key2 = scan.nextInt();
		encryption = encryptTwoKeys(message1, key1, key2);
		System.out.println(encryption);
		decryption = encryptTwoKeys(encryption, 26-key1, 26-key2);
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

	//method for encrypting message with 2 keys
	public static String encryptTwoKeys(String message, int key1, int key2) {
		StringBuilder encryption = new StringBuilder(message);
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
		String shiftAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);

		boolean isLower = false;

		for(int i = 0; i < encryption.length(); i += 2) {
			char currChar = encryption.charAt(i);
			isLower = Character.isLowerCase(currChar);
			currChar = Character.toUpperCase(currChar);
			int index = alphabet.indexOf(currChar);
			if(index != -1) {
				char newChar = shiftAlphabet1.charAt(index);
				if(isLower)
					newChar = Character.toLowerCase(newChar);
				encryption.setCharAt(i, newChar);
			}		
		}

 		for(int i = 1; i < encryption.length(); i += 2) {
			char currChar = encryption.charAt(i);
			isLower = Character.isLowerCase(currChar);
			currChar = Character.toUpperCase(currChar);
			int index = alphabet.indexOf(currChar);
			if(index != -1) {
				char newChar = shiftAlphabet2.charAt(index);
				if(isLower)
					newChar = Character.toLowerCase(newChar);
				encryption.setCharAt(i, newChar);
			}		
		}

 		return encryption.toString();
 	}
}
