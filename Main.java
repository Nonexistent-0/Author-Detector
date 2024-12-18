import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

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

        LinkedList[] importedArrayLists = {new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList()};
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
        //mirroring expected ouput :)

        String[] authors = {"Jon Brodkin", "Andrew Cunningham", "Kyle Orland", "Jennifer Ouellette", "John Timmer"};
        double[] vocabScores = new double[5];
        double[] doubleWordScores = new double[5];
        double[] threeWordScores = new double[5];
        double[] customScores = new double[5];
        double[] compositeScores = new double[5];

        
        for (int i = 0; i < 5; i++) {
            vocabScores[i] = computeSimilarity(oneWordHashTables[i], importedArrayLists[0]);
            doubleWordScores[i] = computeSimilarity(twoWordHashTables[i], importedArrayLists[1]);
            threeWordScores[i] = computeSimilarity(threeWordHashTables[i], importedArrayLists[2]);
            customScores[i] = computeSimilarity(punctuationHashTables[i], importedArrayLists[3]);
            compositeScores[i] = (vocabScores[i] + doubleWordScores[i] + threeWordScores[i] + customScores[i]) / 4;
        }

        
        double maxScore = -1;
        int bestMatch = -1;

        System.out.println("Mystery Text 1\n");
        for (int i = 0; i < 5; i++) {

            System.out.println(authors[i]);
            System.out.println(trunckate(vocabScores[i] * 100) + "% Words_1");
            System.out.println(trunckate(doubleWordScores[i] * 100) + "% Phrases_2");
            System.out.println(trunckate(threeWordScores[i] * 100) + "% Phrases_3");
            System.out.println(trunckate(customScores[i] * 100) + "% CustomCriteria");
            System.out.println(trunckate(compositeScores[i]) + " total composite score.");
            System.out.println();

            if (compositeScores[i] > maxScore) {
                maxScore = compositeScores[i];
                bestMatch = i;
            }
        }
        System.out.println(authors[bestMatch] + " is the closest match.");
        if(trunckate(maxScore * 100) >= 25){
            System.out.println(trunckate(maxScore * 100) + " confidence.");
        } else {
            System.out.println("Not a high enough confidence, so it could be another author!");
        }
    }

    public static double computeSimilarity(HashTable authorHashTable, LinkedList importedList) {
        int hits = 0;

        for (int i = 0; i < importedList.size(); i++) {
            if (authorHashTable.contains(importedList.get(i))) {
                hits++;
            }
        }

        return (double) hits / importedList.size();
    }

    public static double trunckate(double num){
        int decimalPlaces = 3;
        double multiplier = Math.pow(10, decimalPlaces);
        double truncatedValue = Math.floor(num * multiplier) / multiplier;
        return truncatedValue;
    }
}