import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ReadFile {
	private String fileName;
	
	public ReadFile(String s) {
		fileName = s;
	}
	
	public Vector<String> process() {
		
		File f = new File(fileName);
		Scanner sc = null;
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Is it possible that file "+fileName+" does not exist?");
			System.exit(-1);
		}
		
		Vector<String> toR = new Vector<String>();
		
		while (sc.hasNext()) {
			toR.add(sc.next());
		}
		
		return toR;
	}
    public void addFileToDict(CountingDictionary dict){
	int size = process().size();
	for (int i = 0; i<size;i++){
	    dict.insert(process().elementAt(i));
	}

    }
    public void addFileToDict(CountingDictionary dict,CountingDictionary commonWords){
	int size = process().size();
	int size2 = commonWords.allKeyValue().size();
	Vector<String> text = process();
	Vector<Word> text2 = commonWords.allKeyValue();
       	for (int i = 0; i<size;i++){
	    for(int j = 0;j < size2;j++){
	   	if(!(text.elementAt(i).equals(text2.elementAt(j).word()))){
	    dict.insert(text.elementAt(i));
	    break;
		}
		  }
		}	 
    }
}
