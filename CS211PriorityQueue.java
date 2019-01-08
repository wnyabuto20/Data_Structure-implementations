import java.util.Vector;

public class CS211PriorityQueue<V extends Comparable> implements CS211PriorityQueueInterface<V> {
    Comparable[] theQ;
    int count = 1;
    boolean switchtomax = false;
    public CS211PriorityQueue(){
	theQ = new Comparable[1000];
    }
    /*  public V getLeftChild(int i){
	V lChild = theQ[2*i];
	return lChild;
    }
    public V getRightChild(int i){
	V rChild = theQ[2*i+1];
	return rChild;
    } */
    public void bubbleupMin(int x){
	V temp = (V)theQ[x];
	int p = x/2;
	if(x == 1){
	    return;
	}
	else
	if(theQ[x].compareTo(theQ[p]) > 0){
	    return;
	}
	if(theQ[x].compareTo(theQ[p]) < 0){
	    theQ[x] = theQ[p];
	    theQ[p]=temp;
	    bubbleupMin(p);
	}

    }
    public void bubbledownMin(int x){
	V temp = (V) theQ[x];
	int left = x*2;
	int right  = left+1;
	if(theQ[left]== null){
	    return;
	}
	else
	if(theQ[right]== null && theQ[x].compareTo(theQ[left]) > 0 ){
	    theQ[x] = theQ[left];
	    theQ[left]=temp;
	    return;   
	}
	else 
	    if((theQ[x].compareTo(theQ[right]) > 0) && (theQ[left].compareTo(theQ[right])>0)){
		theQ[x] = theQ[right];
		theQ[right]=temp;
		bubbledownMin(right);
	    }
		else
		if((theQ[x].compareTo(theQ[left]) > 0) && (theQ[right].compareTo(theQ[left]) > 0) ){
		    theQ[x] = theQ[left];
		    theQ[left]=temp;
		    bubbledownMin(left);
		    }
    }
    public void bubbleupMax(int x){
	V temp = (V)theQ[x];
	int p = x/2;
	if(x == 1){
	    return;
	}
	else
	    if(theQ[x].compareTo(theQ[p]) < 0){
		return;
	    }
	if(theQ[x].compareTo(theQ[p]) > 0){
	    theQ[x] = theQ[p];
	    theQ[p]=temp;
	    bubbleupMax(p);
	}

    }
    public void bubbledownMax(int x){
	V temp = (V) theQ[x];
	int left = x*2;
	int right  = left+1;
	if(theQ[left]== null){
	    return;
	}
	else
	if(theQ[right]== null && theQ[x].compareTo(theQ[left]) < 0 ){
	    theQ[x] = theQ[left];
	    theQ[left]=temp;
	    return;   
	}
	else 
	    if((theQ[x].compareTo(theQ[right]) < 0) && (theQ[left].compareTo(theQ[right]) < 0)){
		theQ[x] = theQ[right];
		theQ[right]=temp;
		bubbledownMax(right);
	    }
		else
		if((theQ[x].compareTo(theQ[left]) < 0) && (theQ[right].compareTo(theQ[left])< 0) ){
		    theQ[x] = theQ[left];
		    theQ[left]=temp;
		    bubbledownMax(left);
		    }
    }
	
    public void insert(V w){
	int root = 1;
	if(isEmpty()){
	    theQ[1] = w;
	    count +=1;
	}
	else{
	    if(theQ[count] == null){
		theQ[count] = w;
		count += 1;
		if(switchtomax){
		    bubbleupMax(count-1);
		}
		else
		    bubbleupMin(count-1);
	    }
	    else{
		count = count +1; 
		insert(w);
	    }
	}


    }
    public boolean switchtomax(){
     switchtomax = true;
     return switchtomax;
    }
	
    public V peek(){
	return (V)theQ[1];
    }
	
    public V remove(){
	V temp = (V) theQ[1];
	theQ[1] = theQ[count-1];
	theQ[count-1] = null;
	count -=1;
	if(switchtomax){
	    bubbledownMax(1);
	}
	else
	    bubbledownMin(1);
	return temp;
}	
    public void build(Vector<V> words){
	for(int i =0; i<words.size(); i++){
	    insert(words.elementAt(i));
	}
    }
	
    public boolean isEmpty(){

	if(theQ[1] == null){
	    return true;
	}
	else{
	    return false;
	}
    }
}