import java.io.FileNotFoundException;
import java.util.*;

public class FileManager {
    private String[] fileNames = {
            "DAYS_OF_SUMMER.txt",
            "FROZEN.txt",
            "KUNG_FU_PANDA.txt",
            "MY_MOTHER_DREAMS_THE_SATAN'S_DISCIPLES_IN_NEW_YORK.txt",
            "QUANTUM_PROJECT.txt",
            "SEX_AND_THE_CITY.txt",
            "TEN_THINGS_I_HATE_ABOUT_YOU.txt",
            "THE_THINGS_MY_FATHER_NEVER_TAUGHT_ME.txt",
            "TOY_STORY.txt",
            "ZOOTOPIA.txt"
    };

    private List<FileData> dataList = new ArrayList<>();

    public FileManager() {
        processWordInEachTextFile();
    }

    public int getNumberOfFiles() {
        return fileNames.length;
    }

    private void processWordInEachTextFile() {
        try {
            for (String fileName : fileNames) {
                FileData fileData = new FileData(fileName);
                fileData.numberingWord();
                dataList.add(fileData);
            }
        } catch (FileNotFoundException e) {

        }
    }

    public void getCountInEachFile(ParseData parsedData) {
        Queue<ResultData> pq =  new PriorityQueue<>();
        for (FileData data : dataList) {
            ResultData resultData = new ResultData();
            resultData.fileName = data.getFileName();

            int idx = 0;
            for (String word : parsedData.getInput()) {
                int count = data.getWordCount(word);
                int mode = parsedData.getMode(idx);
                if ((mode & ParseData.AND) == ParseData.AND) {
                    if ((mode & ParseData.NOT) == ParseData.NOT) {
                        if (count > 0) {
                            resultData.invalid = true;
                        }
                    } else {
                        if (count == 0) {
                            resultData.invalid = true;
                        }
                    }
                }
                resultData.count += count;
                idx++;
            }
            if (resultData.invalid) {
                resultData.count = 0;
            }
            pq.add(resultData);
        }
        print(pq);
    }

    private void print(Queue<ResultData> pq) {
    	int num = 1;
        while (!pq.isEmpty()) {
            System.out.println("Rank" + num + " : " + pq.peek().fileName);
            pq.poll();
            num++;
        }
    }
}
