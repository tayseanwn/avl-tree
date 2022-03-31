package avlTree;
import java.util.Scanner;
import java.io.*;
 
public class FileWordRead {
  public static void main(String[] args) throws IOException {
 
//	File file = new File("/Users/tayseanwilson-nolan/eclipse-workspace/CS2210/src/assignment4/words.txt");  
    File file = new File("words.txt");
    Scanner input = new Scanner(file); 
 
    int count = 0;
    while (input.hasNext()) {
      String word  = input.next();
      System.out.println(word);
      count = count + 1;
    }
    System.out.println("Word count: " + count);
  }
}
