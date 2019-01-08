
public class Word implements Comparable<Word> {

	private String theWord;
	private int theCount;
	
	public String toString() {
		return theWord+"  "+theCount;
	}
	
	public Word(String word, Integer count) {
		this.theWord = word;
		theCount = count;
	}
	public String getWord(){
	    return theWord;
	}
	public int getCount(){
	    return theCount;
	}
	public void addcount(){
	    theCount = theCount + 1;
	}
	public void removecount(){
	    theCount = theCount - 1;
	}
	
	/* compare to should return a positive number if this is greater
	 * than other, 0 if they are equal and a negative number if this is less.
	 * 
	 * this is greater (less than) if its count is greater (less than) that of 
	 * other.  If the counts are equal, you should determine which theWord is
	 * larger as a String.  compareTo is implemented in Java for Strings, you
	 * should use it
	 */
	public int compareTo(Word other) {
	    if(theCount > other.getCount()){
		return 7;
	    }
	    else
	    if(theCount < other.getCount()){
		return -7;
	    }
	    else
		if(theCount == other.getCount()){
		if(theWord.compareTo(other.getWord()) < 0){
		    return -7;
		}else
		if(theWord.compareTo(other.getWord()) > 0){
		    return 7;
		}
		else
		    return 0;
		}else{
	    return 77;
		}
	}

}
