import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class FileUtils {
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static List<String> splitWords(String content) {
        return Arrays.asList(content.split("\\W+"));
    }

    public static void printSortedWords(List<String> sortedWords) {
        System.out.println("Слова в алфавитном порядке:");
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }

    public static void printWordFrequencies(Map<String, Integer> wordFrequencies,  int totalWords) {
        System.out.println("\nЧастота вхождения слов:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            double percentage = (entry.getValue() / (double) totalWords) * 100;
            System.out.printf("%s: %d (%.2f%%)%n", entry.getKey(), entry.getValue(), percentage);
        }
    }

    public static void printMostFrequentWords(List<String> mostFrequentWords, int maxFrequency) {
        System.out.println("\nСлова с максимальной частотой вхождения (" + maxFrequency + " раз):");
        for (String word : mostFrequentWords) {
            System.out.println(word);
        }
    }
}
