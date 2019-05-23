# HashTable-PriorityQueue-Trie
This work consists of implementations of a HashTable, a PriorityQueue and a Trie.The HashTable defined in CountingDictionary.java is used
to build a countingDictionary that keeps track of how many times a word appears in a document being read. It is implemented using 
an array. CountingDictionary.java makes use of the Word.java's Word object to keep track of a word and its metadata and store the 
Word objects in a HashTable.
PriorityQueue.java implements a PriorityQueue that stores words in order of number of appearences in a .txt test document.
Trie.java implements a trie data structure that keeps track of words in a .txt file.
## Getting Started
To get the CountingDictionary and PriorityQueue working, any (preferrably the latest) version of Java needs to be installed. A
good text editor would also come in handy.

### Prerequisites
There are no additional dependencies required. The code can simply be downloaded and run.
### Installing
Download all files/ clone the repository,compile and run the files with the prefix "Test". You can adjust them to test the different data structures implemented here.
## Running the tests
The tests are run on TestLab3.java. For the CountingDictionary, this simply takes a test .txt document, reads it
and stores the metadata (word and number of appearences) of each word in a HashTable (defined in CountingDictionary.java) from 
which it can be accessed and manipulated through methods available in the same file.
For the PriorityQueue it reads a .txt file and stores the words in a priorityQueue based on number of appearances.

