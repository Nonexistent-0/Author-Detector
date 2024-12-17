import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException{
        HashTable[][] oneWordHashTables = {{new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}};

                                         
        HashTable[][] twoWordHashTables = {{new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                           {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}};

        
        HashTable[][] threeWordHashTables = {{new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                             {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                             {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                             {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                             {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}};

        HashTable[][] punctuationHashTables = {{new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                               {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                               {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                               {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}, 
                                               {new HashTable(), new HashTable(), new HashTable(), new HashTable(), new HashTable()}};

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
                    oneWordHashTables[i / 5][i % 5].put(splitText[j]);
                }

                for (int j = 0; j < splitText.length - 1; j++) {
                    twoWordHashTables[i / 5][i % 5].put(splitText[j] + " " + splitText[j + 1]);
                }
                
                for (int j = 0; j < splitText.length - 2; j++) {
                    threeWordHashTables[i / 5][i % 5].put(splitText[j] + " " + splitText[j + 1] + " " + splitText[j + 2]);
                }

                String punctuationString = text.replaceAll("[\\w\\s]", "");

                for (int j = 0; j < punctuationString.length(); j++) {
                    punctuationHashTables[i / 5][i % 5].put(punctuationString.substring(j, j+1));
                }

            }


        }

        

    }
}