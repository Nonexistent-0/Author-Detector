import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        HashTable[] oneWordHashTables = {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()};

        HashTable[] twoWordHashTables = {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()};

        HashTable[] threeWordHashTables = {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()};

        HashTable[] punctuationHashTables = {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()};

        File textsFolder = new File("Texts");
        File[] files = textsFolder.listFiles();
        for (int i = 0; i < 25; i++) {

            BufferedReader br = new BufferedReader(new FileReader(files[i]));
            String text;

            while((text = br.readLine()) != null) {

                if (text.equals("")) {
                    continue;
                }

                String[] splitText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (int j = 0; j < splitText.length; j++) {
                    oneWordHashTables[i / 5].put(splitText[j]);
                }

                for (int j = 0; j < splitText.length - 1; j++) {
                    twoWordHashTables[i / 5].put(splitText[j] + " " + splitText[j + 1]);
                }
                
                for (int j = 0; j < splitText.length - 2; j++) {
                    threeWordHashTables[i / 5].put(splitText[j] + " " + splitText[j + 1] + " " + splitText[j + 2]);
                }

                String punctuationString = text.replaceAll("[\\w\\s]", "");

                for (int j = 0; j < punctuationString.length(); j++) {
                    punctuationHashTables[i / 5].put(punctuationString.substring(j, j+1));
                }

            }


        }

        ArrayList[] importedArrayLists = {new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()};
        BufferedReader br = new BufferedReader(new FileReader("importedText.txt"));
        String text;

        while((text = br.readLine()) != null) {
            String[] splitText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            for (int j = 0; j < splitText.length; j++) {
                importedArrayLists[0].add(splitText[j]);
            }

            for (int j = 0; j < splitText.length - 1; j++) {
                importedArrayLists[1].add(splitText[j] + " " + splitText[j + 1]);
            }
                
            for (int j = 0; j < splitText.length - 2; j++) {
                importedArrayLists[2].add(splitText[j] + " " + splitText[j + 1] + " " + splitText[j + 2]);
            }

            String punctuationString = text.replaceAll("[\\w\\s]", "");

            for (int j = 0; j < punctuationString.length(); j++) {
                importedArrayLists[3].add(punctuationString.substring(j, j+1));
            }
        }

        oneWordHashTables[0].printInOrder(); 
        
    }
}