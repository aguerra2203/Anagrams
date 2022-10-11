import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Anagrams {

	public static void main(String[] args) throws FileNotFoundException {
		// create a scanner object
		Scanner keyboard = new Scanner(System.in);
		Scanner fileReader = null;
		HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();

		// instantiate the scanner to read the dictionary file
		// instantiate a new hashMap of LinkedLists using the word from the dictionary
		// and the letters in alphabetical order
		try {
			fileReader = new Scanner(new File("Dictionary.txt"));
			// while the file has a next line
			while (fileReader.hasNext()) {
				// read the file save each word as a string
				String keyword = fileReader.next().toLowerCase();

				// convert the string to a char array and sort it into alphabetical order
				char[] value = keyword.toCharArray();
				Arrays.sort(value);


				String alphabetical = new String(value);
				
				if (anagrams.containsKey(alphabetical)) {
					anagrams.get(alphabetical).add(keyword);
				}
				else {
					ArrayList<String> words = new ArrayList<String>();
					words.add(keyword);
					anagrams.put(alphabetical, words);
				}

				
				// use the sorted word as a key and place them in a hash map, grouping all words
				// with the same characters together in the same bucket

			}
			System.out.print("Which word would you like to find the anagrams of? ");
			String userInput = keyboard.next();
			char[] userArray = userInput.toCharArray();
			Arrays.sort(userArray);
			String alphabeticalInput = new String(userArray);
			System.out.println(anagrams.get(alphabeticalInput));
			keyboard.close();

 
		}
		 
		catch (IOException e) {
			keyboard.close();
			// throw new FileNotFoundException if there is nothing to read
			throw new FileNotFoundException("Name of file is not valid, please try again");

		}

	}

}
