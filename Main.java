import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Main{

    final static String[] authorFiles = {"Texts/Andrew Cunnigham/AnderewCunningham1.txt", "Texts/Andrew Cunnigham/AnderewCunningham2.txt", "Texts/Andrew Cunnigham/AnderewCunningham3.txt", "Texts/Andrew Cunnigham/AnderewCunningham4.txt", "Texts/Andrew Cunnigham/AnderewCunningham5.txt", 
"Texts/Jennifer Ouellette/JenniferOuellette1.txt", "Texts/Jennifer Ouellette/JenniferOuellette2.txt", "Texts/Jennifer Ouellette/JenniferOuellette3.txt", "Texts/Jennifer Ouellette/JenniferOuellette4.txt", "Texts/Jennifer Ouellette/JenniferOuellette5.txt",
"Texts/John Trimmer/JohnTrimmer1.txt", "Texts/John Trimmer/JohnTrimmer2.txt", "Texts/John Trimmer/JohnTrimmer3.txt", "Texts/John Trimmer/JohnTrimmer4.txt", "Texts/John Trimmer/JohnTrimmer5.txt",
"Texts/John Brodkin/JohnBrodkin1.txt", "Texts/John Brodkin/JohnBrodkin2.txt", "Texts/John Brodkin/JohnBrodkin3.txt", "Texts/John Brodkin/JohnBrodkin4.txt", "Texts/John Brodkin/JohnBrodkin5.txt",
"Texts/Kyle Orland/KyleOrland1.txt", "Texts/Kyle Orland/KyleOrland2.txt", "Texts/Kyle Orland/KyleOrland3.txt", "Texts/Kyle Orland/KyleOrland4.txt", "Texts/Kyle Orland/KyleOrland5.txt"};
    public static void main(String[] args) {

      HashTable[][] hashTables = {{new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                  {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                  {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}};

      for(int i = 0; i < hashTables.length; i++){
         for(int j = 0; j < hashTables[0].length; j++){
            for(String str : authorFiles){

               File file = new File(str);
               
               try{
                  Scanner inputStream = new Scanner(file);
                  while(inputStream.hasNext()){
                  String data = inputStream.next();
                  hashTables[i][j].put(data);
               }
                  inputStream.close();
               }catch (FileNotFoundException e) {
                  e.printStackTrace();
               }
            }
         }
      }
    }
}