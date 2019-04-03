import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordFilter {
    private File file = new File("src/data/stopwords.txt");
    private Set<String> filterSet = new HashSet<>();

    public WordFilter() {
        try {
            String text = readAllLinesInFile();
            String[] splitedText = text.split(",");
            for (String str : splitedText) {
                filterSet.add(str);
            }
        } catch (FileNotFoundException e) {

        }
    }

    private String readAllLinesInFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();
    }

    public boolean isExist(String str) {
        for (String element: filterSet) {
            if (element.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
