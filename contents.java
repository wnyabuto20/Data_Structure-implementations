public class contents{
    String key;
    int value;
    //contents next;
    Word forVect;
    public contents(String key, int value){
	this.key = key;
	this.value = value;
	//next = null;
	Word holder = new Word(key,value);
	forVect = holder;
    }
    //public contents(){
    //	next = null;
    // }
    public String getKey(){
	return key;
    }
    public int getValue(){
	return value;
    }

}