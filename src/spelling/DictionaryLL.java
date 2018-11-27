package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
	// creating a new object of LinkedList 
	
	public  DictionaryLL() {
		dict =  new LinkedList<String>();
	}


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	//converting to lower case 
    	if (word == null ) throw new  NullPointerException("Word is null");
    	word = word.toLowerCase();
    	if (!isWord(word)) {
    		dict.add(word);
    		return true;
    	}
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
        return dict.size() ;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	
    	for (String word : dict) {
    		if (word.equals(s.toLowerCase())) return true;
    	}
        return false;
    }

}
