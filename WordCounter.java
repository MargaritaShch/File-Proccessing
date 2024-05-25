import java.util.*;

public class WordCounter {
    private final Map<String, Integer> wordCount = new HashMap<>();
    private int totalWords = 0;

    public void countWords(List<String> words) {
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                totalWords++;
            }
        }
    }

    public List<String> getSortedWords() {
        Set<String> wordSet = new HashSet<>(wordCount.keySet());
        List<String> sortedWords = new ArrayList<>(wordSet);
        Collections.sort(sortedWords);
        return sortedWords;
    }

    public Map<String, Integer> getWordFrequencies() {
        return wordCount;
    }

    public int getMaxFrequency() {
        return Collections.max(wordCount.values());
    }

    public List<String> getMostFrequentWords(int maxFrequency) {
        List<String> mostFrequentWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentWords.add(entry.getKey());
            }
        }
        return mostFrequentWords;
    }

    public int getTotalWords() {
        return totalWords;
    }
}
