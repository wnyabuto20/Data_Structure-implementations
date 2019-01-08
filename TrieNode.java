import java.util.Vector;

public class TrieNode {

    private Word wordHere;
    private TrieNode[] links;
    int cycles; 
    public TrieNode() {
	wordHere = null;
	links= new TrieNode[26];
	cycles = 0;
    }
    
    private int let(char c) {
	return c - 'a';
    }

    private char firstChar(String key) {
	return key.charAt(0);
    }
	
    private String rest(String key) {
	return key.substring(1,key.length());
    }
	
    private TrieNode linkWordStart(String start) {
	return links[let(firstChar(start))];
    }
	
    public void insert(String key,String toHere) {
	Word word1 = new Word(toHere,1);
	TrieNode node = new TrieNode();
	if (key.length() == 0) {
	    if (wordHere == null){
		wordHere = word1;
		}
	    else {wordHere.addcount();}
	}
	else {
	    if (linkWordStart(key) == null){
		links[let(firstChar(key))] = node;
		node.insert(rest(key),toHere);
	    }
	    else {
		linkWordStart(key).insert(rest(key),toHere);
	    }
	}	

    }
    public Word find(String key) {
	if (key.length() == 0) {
		    if (wordHere==null)
			return null;
		    else return wordHere;
	}
	else {
	    if (linkWordStart(key) == null)
		return null;
	    else return linkWordStart(key).find(rest(key));
	}		
    }

    public void allKeyValue(Vector v) {
	if(wordHere != null){
	    if(!v.contains(wordHere)){
	    v.add(wordHere);
		}
	}
	for (int i =0; i<26; i++){
	    if(links[i] != null){
		links[i].allKeyValue(v);
	    }
	}		
    }

    public void spellCheck1(Vector v, String start) {
	if (start.length() == 0) {
	    allKeyValue(v);
	}
	else {
	    if(linkWordStart(start) != null){
		linkWordStart(start).spellCheck1(v,rest(start));
	    }
	    else{
	    spellCheck1(v,rest(start)); 
	     }
	}	
    }
    public void prefixMatch(Vector v, String start) {
	if (start.length() == 0) {
	    allKeyValue(v);
	}
	else {
	    if(linkWordStart(start) != null){
	    linkWordStart(start).prefixMatch(v,rest(start));	    }
	}			
    }
    
    public void allKeyValue(Vector v, int length) {
	if(wordHere != null && wordHere.getWord().length() >= length){
	    if(!v.contains(wordHere)){
	    v.add(wordHere);
		}
	}
	for (int i =0; i<26; i++){
	    if(links[i] != null){
		links[i].allKeyValue(v);
	    }
	}		
    }

    public void spellCheck2(Vector ws, String key, int errs){
    if (key.length() == 0) {
	    if(wordHere != null ){ 
		 ws.add(wordHere);
	     }
	}
	else {
	    if(errs > 0){
		int errs2 = errs-1;
		for(int i =0;i<26;i++){
		if(links[i] != null){
		    if(i != let(firstChar(key)) ){
			links[i].spellCheck2(ws,rest(key),errs2);	
		    }
		    else{
			links[i].spellCheck2(ws,rest(key),errs);
		    }
		}	
	    }
	    }else
		if(errs == 0){
		    if(linkWordStart(key) != null){
			linkWordStart(key).spellCheck2(ws,rest(key),0);
		    }
	    	}
	}	
    }
    public void samefirstcharanddistance(Vector ws, String key, int errs){    //Checks for words that are of the same firstCharacter and within the max distance given.
	Vector v = new Vector<Word>();
	Vector w = new Vector<Word>();
	spellCheck2(w,key,errs);
	prefixMatch(v,key.substring(0,1));
	for(int i= 0;i<w.size();i++){
	for(int j= 0;j<v.size();j++){
	    if(w.elementAt(i) == v.elementAt(j))
		ws.add(w.elementAt(i));
	} 
	}                                                                                                                                                                                 
    }
    public Word matchRegexjr(String key){ /*takes in a String  consisting of Alphabetic letters alternating with * or ?; checks the alphabetic letters ignoring the other characters and returns the word corresponding to the pattern of the letters; in Trie, matchRegexjr() returns the count of this word
This is a simpler version of matchRegex where the "wild characters" don't match anything and only serve as obstacles to be skipped*/

	if (key.length() == 0) {
	    if (wordHere==null)
			return null;
	    else return wordHere;
	}
	else {
	    String temp = rest(key);
	    if(firstChar(key) == '*'||firstChar(key)=='?'){  
		if (linkWordStart(rest(key)) == null)
		    return null;
		else return linkWordStart(temp).matchRegexjr(rest(temp)); // here I skip the obstacle character (* or ?) and keep following the letters.
	    }
	    else{
	    if (linkWordStart(key) == null)
		return null;
	    else return linkWordStart(key).matchRegexjr(rest(key));
	}		
    }
}
    
    public void print(String string) {
	if (wordHere != null)
	    System.out.println(string+" "+wordHere);
	else System.out.println(string+" empty");
	for (int i =0; i<26; i++) {
	    if (links[i]!=null){
		links[i].print(string+"-");
	    }
	}
    }
    public boolean anyKids(String key){
	Vector<Word> v = new Vector();
	links[let(firstChar(key))].allKeyValue(v);
	if(v.isEmpty())	{
	    return false;
	  }
	return true;
    }
    public void deldangling(String key){
	if (key.length() == 0) {
	    return;
	}
	else {
	    if(anyKids(key)){
  		linkWordStart(key).deldangling(rest(key));
	    }
	    else{
		links[let(firstChar(key))] = null;

	    }
        }
    }

    public boolean delete(String key) {
	if(find(key) != null){
	    if (key.length() == 0) {
		wordHere = null;	
	    }
	    else {	
		linkWordStart(key).delete(rest(key));	    
	    }	
	    return true;
	}
	return false;
    }
}


