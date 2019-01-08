import java.util.Scanner;
import java.util.Vector;
public class TestLab3 {
    public static void main(String[]args){
	/*	CountingDictionary dict = new CountingDictionary(15001);
	Scanner keyboard = new Scanner(System.in);
	//System.out.println("file name?");
	// String filename = keyboard.nextLine();
	String filename = "TextFile1.txt";
	ReadFile text = new ReadFile(filename);
	text.addFileToDict(dict);

	System.out.println(dict.allKeyValue());
	CS211PriorityQueue test = new CS211PriorityQueue<Word>();
	test.build(dict.allKeyValue());
	System.out.println();
	System.out.println("MIN WORDS");
	System.out.println();
	for(int i = 0 ;i <10; i++){
	    System.out.println(test.remove());
	}
	CS211PriorityQueue test2 = new CS211PriorityQueue<Word>();
	System.out.println();
	System.out.println("MAX WORDS");
	System.out.println();
	test2.switchtomax();
	test2.build(dict.allKeyValue());

	for(int i = 0 ;i <10; i++){
	    System.out.println(test2.remove());
	    }*/
	CountingDictionary comm = new CountingDictionary(15000); //adding uncommon words.
	CountingDictionary uncomm = new CountingDictionary(20000);
	String filename1 = "CommonWords.txt";
	String filename2 = "TextFile2.txt";
	ReadFile one = new ReadFile(filename1);
	one.addFileToDict(comm);
	ReadFile two = new ReadFile(filename2);
	two.addFileToDict(uncomm,comm);
	System.out.println(uncomm.allKeyValue());
    }
}