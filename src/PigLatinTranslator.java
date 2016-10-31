// Translate from English to Pig Latin
// Prompt the user to word
// if word start with vowel then add "way" at the end of the word
// if the word start with consonant then move all consonant to the first vowel to the end of the word
// then add "ay" to the end of the word

// welcome to the Pig Translator!
// Enter a line to be translated: 

import java.io.*;

//Translate a sentence into pig latin

public class PigLatinTranslator {

	// To use for input.
	private static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

	// Main method
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to the Pig Latin Translator!\n");
		
		// Get a string
		System.out.print("Enter a line to be translated: ");
		String english = getString();

		// Translate and print back out
		String latin = pigLatin(english);
		System.out.println(latin);
	}

	// Method to translate a sentence word by word.

	private static String pigLatin(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {

			// Take care of punctuation and spaces
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}

			// If there aren't any words left, stop.
			if (i >= s.length())
				break;

			// Otherwise we're at the beginning of a word.
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			// Now we're at the end of a word, so translate it.
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	// Method to test whether a character is a letter or not.
	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	// Method to translate one word into pig latin.

	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + word.substring(0, split) + "ay";
	}

	// Method to find the index of the first vowel in a word.

	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}

	private static String getString() throws IOException {
		return buf.readLine();
	}

}