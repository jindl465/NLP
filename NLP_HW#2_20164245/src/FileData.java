import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileData {
    private String fileName;
    private Map<String, Integer> wordMap = new HashMap<>();
    private WordFilter filter = new WordFilter();
    private int count;

    public FileData(String name) {
        fileName = name;
    }

    public void numberingWord() throws FileNotFoundException {
        File file = new File("src/data/" + fileName);
        Scanner scanner = new Scanner(file);
        List<String> wordList = new ArrayList<>();
        count = 0;
        
        while (scanner.hasNextLine()) {
            String[] tempWords = scanner.nextLine().split(" ");
            for (String word : tempWords) {
                String trimedWord = word.trim();
                if (trimedWord.length() == 0) {
                    continue;
                }
                trimedWord = trimedWord.replaceAll("[().,;:!@#$%^&*?]", "").toLowerCase();

                if (filter.isExist(trimedWord)) {
                    continue;
                }

                if (wordMap.containsKey(trimedWord)) {
                    wordMap.replace(trimedWord, wordMap.get(trimedWord) + 1);
                    count++;
                } else {
                    wordMap.put(trimedWord, 1);
                    count++;
                };
            }
        }
        //print();
    }

    public void print() {
        Set<String> keySet = wordMap.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + wordMap.get(key));
        }
    }

    public Set<String> getKeySet() {
        return wordMap.keySet();
    }

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public int getWordCount(String key) {
        return wordMap.get(key) != null ? wordMap.get(key) : 0;
    }

    public String getFileName() {
        return fileName;
    }
    
    public int getTotalCount() {
    	return count;
    }
    
    public int normalization(String key) {
    	return this.getWordCount(key)/this.count;
    }
}
