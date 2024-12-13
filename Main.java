import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Main {

    final static String[] authorFiles = {"Texts\\Andrew Cunnigham\\AnderewCunningham1.txt", "Texts\\Andrew Cunnigham\\AnderewCunningham2.txt", "Texts\\Andrew Cunnigham\\AnderewCunningham3.txt", "Texts\\Andrew Cunnigham\\AnderewCunningham4.txt", "Texts\\Andrew Cunnigham\\AnderewCunningham5.txt", 
                                          "Texts\\Jennifer Ouellette\\JenniferOuellette1.txt", "Texts\\Jennifer Ouellette\\JenniferOuellette2.txt", "Texts\\Jennifer Ouellette\\JenniferOuellette3.txt", "Texts\\Jennifer Ouellette\\JenniferOuellette4.txt", "Texts\\Jennifer Ouellette\\JenniferOuellette5.txt",
                                          "Texts\\John Trimmer\\JohnTrimmer1.txt", "Texts\\John Trimmer\\JohnTrimmer2.txt", "Texts\\John Trimmer\\JohnTrimmer3.txt", "Texts\\John Trimmer\\JohnTrimmer4.txt", "Texts\\John Trimmer\\JohnTrimmer5.txt",
                                          "Texts\\John Brodkin\\JohnBrodkin1.txt", "Texts\\John Brodkin\\JohnBrodkin2.txt", "Texts\\John Brodkin\\JohnBrodkin3.txt", "Texts\\John Brodkin\\JohnBrodkin4.txt", "Texts\\John Brodkin\\JohnBrodkin5.txt",
                                          "Texts\\Kyle Orland\\KyleOrland1.txt", "Texts\\Kyle Orland\\KyleOrland2.txt", "Texts\\Kyle Orland\\KyleOrland3.txt", "Texts\\Kyle Orland\\KyleOrland4.txt", "Texts\\Kyle Orland\\KyleOrland5.txt"};
    public static void main(String[] args) throws IOException{
      HashTable[][] hashTables = {{new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}};

      File textsFolder = new File("Texts");
      File[] files = textsFolder.listFiles();
      for (int i = 0; i < 25; i++) {

         BufferedReader br = new BufferedReader(new FileReader(files[i]));
         String text;

         while((text = br.readLine()) != null) {
            String[] splitText = text.split(" ");
            for (String str : splitText) {
               hashTables[0][0].put(str);
            }
         }


      }

      hashTables[0][0].printInOrder();

   }
}