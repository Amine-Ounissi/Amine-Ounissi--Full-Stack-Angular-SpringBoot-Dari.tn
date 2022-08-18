package tn.Dari.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import tn.Dari.entities.Announcement;
import tn.Dari.repository.CommentRepository;

public class FilterService {
	@Autowired
	Announcement adRepository;
	@Autowired
	CommentRepository commentRepository;
	private static int largestWordLength = 0;
	private static Map<String, String[]> allBadWords = new HashMap<String, String[]>();
	
	
	public static String getCensoredText(final String input) {
		loadBadWords();
		if (input == null) {
			return "comment empty!";
		}

		String modifiedInput = input;
		System.out.println("input2" + input);
		

		// ignore any character that is not a letter
		modifiedInput = modifiedInput.toLowerCase().replaceAll("[^a-zA-Z]", "");

		ArrayList<String> badWordsFound = new ArrayList<>();

		// iterate over each letter in the word
		for (int start = 0; start < modifiedInput.length(); start++) {
			// from each letter, keep going to find bad words until either the
			// end of
			// the sentence is reached, or the max word length is reached.
			for (int offset = 1; offset < (modifiedInput.length() + 1 - start)
					&& offset < largestWordLength; offset++) {
				String wordToCheck = modifiedInput.substring(start, start + offset);
				if (allBadWords.containsKey(wordToCheck)) {
					String[] ignoreCheck = allBadWords.get(wordToCheck);
					boolean ignore = false;
					for (int stringIndex = 0; stringIndex < ignoreCheck.length; stringIndex++) {
						if (modifiedInput.contains(ignoreCheck[stringIndex])) {
							ignore = true;
							System.out.println("badwordfound IS FOUND" + badWordsFound);
							System.out.println("word to check IS FOUND" + wordToCheck);
							break;
						}
					}

					if (!ignore) {
						badWordsFound.add(wordToCheck);
						System.out.println("badwordfound" + badWordsFound);
						System.out.println("word to check" + wordToCheck);
					}
				}
			}
		}

		String inputToReturn = input;
		System.out.println("input" + inputToReturn);
		for (String swearWord : badWordsFound) {
			char[] charsStars = new char[swearWord.length()];
			Arrays.fill(charsStars, '*');
			final String stars = new String(charsStars);

			// The "(?i)" is to make the replacement case insensitive.
			inputToReturn = inputToReturn.replaceAll("(?i)" + swearWord, stars);
		}

		return inputToReturn;
	} // end getCensoredText*/

	private static void loadBadWords() {
		int readCounter = 0;
		try {
			// The following spreadsheet is from:
			// https://gist.github.com/PimDeWitte/c04cc17bc5fa9d7e3aee6670d4105941
			// (If the spreadsheet ever ceases to exist, then this application
			// will still function normally otherwise - it just won't censor any
			// swear words.)

			FileReader fr = new FileReader("C:/Users/pc rog/Desktop/BadWords.txt");
			BufferedReader reader = new BufferedReader(fr);
			System.out.println("file "+reader);
			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(new URL(
			// "https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv")
			// .openConnection().getInputStream()));

			String currentLine = "";
			while ((currentLine = reader.readLine()) != null) {
				readCounter++;
				String[] content = null;
				try {
					if (1 == readCounter) {
						continue;
					}

					content = currentLine.split(",");
					if (content.length == 0) {
						continue;
					}

					final String word = content[0];

					if (word.startsWith("-----")) {
						continue;
					}

					if (word.length() > largestWordLength) {
						largestWordLength = word.length();
					}

					String[] ignore_in_combination_with_words = new String[] {};
					if (content.length > 1) {
						ignore_in_combination_with_words = content[1].split("_");
					}

					// Make sure there are no capital letters in the spreadsheet
					allBadWords.put(word.replaceAll(" ", "").toLowerCase(), ignore_in_combination_with_words);
				} catch (Exception except) {
				}
			} // end while
		} catch (IOException except) {
		}
	} 
	
}		
