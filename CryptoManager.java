/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: 3/19/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Matthew Campbell
*/
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		boolean ok = true;
		for (int i =0; i<plainText.length();i++){
			if(!(charInRange(plainText.charAt(i)))){
				ok=false;
			}
		}
		
			return ok;
	}
	private static boolean charInRange(char charAt){
		if(charAt>=LOWER_RANGE && charAt<=UPPER_RANGE)
			return true;
		else
			return false;
		}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String eText="";
		if(isStringInBounds(plainText)){
			for(int i=0; i<plainText.length();i++){
				char thisChar=plainText.charAt(i);
				int encryptedCharInt = ((int)thisChar+key);
				while (encryptedCharInt>UPPER_RANGE) {
					encryptedCharInt-=RANGE;
					}
				eText+=(char)encryptedCharInt;
				}
			}
		else	
			return "The selected string is not in bounds, Try again.";
		return eText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellaso) {
		String eText="";
		int bellasoLength=bellaso.length();
		for(int i=0;i<plainText.length();i++){
			char thisChar=plainText.charAt(i);
			int encryptedCharInt=((int)thisChar+(int)bellaso.charAt(i%bellasoLength));
			while (encryptedCharInt>UPPER_RANGE){
						encryptedCharInt-=RANGE;
						}
					eText+=(char)encryptedCharInt;
						}
		return eText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String decryptedText="";
		for (int i=0; i<encryptedText.length();i++){
			char thisChar = encryptedText.charAt(i);
			int decryptedCharInt = ((int)thisChar-key);
			while (decryptedCharInt<LOWER_RANGE){
				decryptedCharInt+=RANGE;
				}
			decryptedText+=(char)decryptedCharInt;
			}
		return decryptedText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decryptedText="";
		int bellasoStrLength=bellasoStr.length();
		for (int i=0;i<encryptedText.length();i++){
			char thisChar=encryptedText.charAt(i);
			int decryptedCharInt=((int)thisChar-(int)bellasoStr.charAt(i%bellasoStrLength));
			while (decryptedCharInt<LOWER_RANGE){
				decryptedCharInt+=RANGE;
				}
			decryptedText+=(char)decryptedCharInt;
				}
		return decryptedText;}
	}

