import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class FileProccessing {
    public static void main(String[] args){
        String filePath = "Text/text";
        try{
            String content =  new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = content.split("\\W+");

            Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

            Map<String, Integer> wordCount = new HashMap<>();

            for(String word : words){
                if(!word.isEmpty()){
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
                }
            }

            int maxFrequency = Collections.max(wordCount.values());
            List<String> mostFrequency = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
                if(entry.getValue() == maxFrequency){
                    mostFrequency.add(entry.getKey());
                }
            }

            System.out.println("Слова в алфавитном порялке:");
            for(String word : words){
                if(!word.isEmpty()){
                    System.out.println(word);
                }
            }

            System.out.println("\nЧастота вхождения слоа:");
            for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\nСлова с максимальной частотой вхождения (" + maxFrequency + " раз):");
            for(String word : words){
                System.out.println(word);
            }
        } catch(IOException e){
            e.printStackTrace();

        }
    }
}