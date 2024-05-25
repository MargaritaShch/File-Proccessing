import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileProcessing {
    public static void main(String[] args) {
        String filePath = "Text/text"; 

        try {
            String content = FileUtils.readFile(filePath);
            List<String> words = FileUtils.splitWords(content);

            WordCounter wordCounter = new WordCounter();
            wordCounter.countWords(words);

            List<String> sortedWords = wordCounter.getSortedWords();
            Map<String, Integer> wordFrequencies = wordCounter.getWordFrequencies();
            int maxFrequency = wordCounter.getMaxFrequency();
            List<String> mostFrequentWords = wordCounter.getMostFrequentWords(maxFrequency);
            int totalWords = wordCounter.getTotalWords();

            FileUtils.printSortedWords(sortedWords);
            FileUtils.printWordFrequencies(wordFrequencies, totalWords);
            FileUtils.printMostFrequentWords(mostFrequentWords, maxFrequency);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}