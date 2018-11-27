package document;

import java.util.ArrayList;
import java.util.List;

/** 
 * A naive implementation of the Document abstract class. 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document 
{
	/** Create a new BasicDocument object
	 * 
	 * @param text The full text of the Document.
	 */
	public BasicDocument(String text)
	{
		super(text);
	}
	
	
	/**
	 * Get the number of words in the document.
	 * A "word" is defined as a contiguous string of alphabetic characters
	 * i.e. any upper or lower case characters a-z or A-Z.  This method completely 
	 * ignores numbers when you count words, and assumes that the document does not have 
	 * any strings that combine numbers and letters. 
	 * 
	 * Check the examples in the main method below for more information.
	 * 
	 * This method should process the entire text string each time it is called.  
	 * 
	 * @return The number of words in the document.
	 */
	@Override
	public int getNumWords()
	{
		//TODO: Implement this method in week 2 according to the comments above.  
		// See the Module 2 support videos if you need help.
		
		return getTokens("[a-zA-Z]+").size();
	 
	}
	
	/**
	 * Get the number of sentences in the document.
	 * Sentences are defined as contiguous strings of characters ending in an 
	 * end of sentence punctuation (. ! or ?) or the last contiguous set of 
	 * characters in the document, even if they don't end with a punctuation mark.
	 * 
	 * Check the examples in the main method below for more information.  
	 * 
	 * This method should process the entire text string each time it is called.  
	 * 
	 * @return The number of sentences in the document.
	 */
	@Override
	public int getNumSentences()
	{
	    //TODO: Implement this method.  See the Module 2 support videos 
        // if you need help.
        return this.getTokens("[^?!.]+").size();
	}
	
	/**
	 * Get the total number of syllables in the document (the stored text). 
	 * To count the number of syllables in a word, it uses the following rules:
	 *       Each contiguous sequence of one or more vowels is a syllable, 
	 *       with the following exception: a lone "e" at the end of a word 
	 *       is not considered a syllable unless the word has no other syllables. 
	 *       You should consider y a vowel.
	 *       
	 * Check the examples in the main method below for more information.  
	 * 
	 * This method should process the entire text string each time it is called.  
	 * 
	 * @return The number of syllables in the document.
	 */
	@Override
	public int getNumSyllables()
	{
	    //TODO: Implement this method in week 2.  See the Module 2 support videos 
        // if you need help.  And note that there is no need to use a regular
		// expression for the syllable counting.  We recommend you implement 
		// the helper function countSyllables in Document.java using a loop, 
		// and then call it here on each word.
	
		List<String> words =  new ArrayList<String>();
		words =  getTokens("[a-zA-Z]+");
		int totalSyll = 0;
		for (String word : words ) {
			totalSyll = totalSyll + this.countSyllables(word);
		}
		
		return totalSyll;
		
	}
	
	/*
	 * This method is going to get a word and return # of Syllables on that word
	 * This is helper function for getNumSyllables
	 */
	
	/**
	 * @param word as String 
	 * @return number of vowel Char on the word
	 */
	
//	public int countSyllables(String word ) {
//		int numSyll = 0; 
//		int lenght = word.length();
//	
//		if (isVowel(word.charAt(0))) numSyll++;
//			
//		
//		for (int i = 1; i < lenght ; i++) {
//			if (isVowel(word.charAt(i)) && !isVowel(word.charAt(i-1))) {
//				numSyll++;
//			}
//			
//		}
//		// This part is checking the last Char is 'e' or not to apply the rule we have about it
//		if ((word.charAt(lenght-1) == 'e' && (numSyll > 1 )  && !isVowel(word.charAt(lenght-2)))) 
//		 numSyll--;
//	
//		return numSyll;
//	}


/**
 * this is going to check if a char is a vowel or not
 * @param ch
 * @return Boolean value that indicate is it vowel or not
 */
//	public boolean isVowel (char ch) {
//		if (ch == 'a' || ch == 'e' || ch == 'y'|| ch == 'i'|| ch == 'o'|| ch =='u' || ch == 'A' || ch == 'E' || ch == 'Y'|| ch == 'I'|| ch == 'O'|| ch =='U') {
//			return true;
//		} else { 
//			return false;
//		}
//	}
	
	
	
	/* The main method for testing this class. 
	 * You are encouraged to add your own tests.  */
	public static void main(String[] args)
	{
		/* Each of the test cases below uses the method testCase.  The first 
		 * argument to testCase is a Document object, created with the string shown.
		 * The next three arguments are the number of syllables, words and sentences 
		 * in the string, respectively.  You can use these examples to help clarify 
		 * your understanding of how to count syllables, words, and sentences.
		 */
		testCase(new BasicDocument("This is a test.  How many???  "
		        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
				16, 13, 5);
		testCase(new BasicDocument(""), 0, 0, 0);
		testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
		        + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
		testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
		testCase(new BasicDocument("Here is a series of test sentences. Your program should "
				+ "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
				+ "the correct amount of syllables (example, for example), "
				+ "but most of them will."), 49, 33, 3);
		testCase(new BasicDocument("Segue"), 2, 1, 1);
		testCase(new BasicDocument("Sentence"), 2, 1, 1);
		testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
		testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
		         32, 15, 1);
	}
	
}
