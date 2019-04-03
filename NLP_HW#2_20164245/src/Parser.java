import java.util.ArrayList;
import java.util.List;

public class Parser {

    public ParseData parse(String query) {
        ParseData data = new ParseData();

        String[] arr = query.split("[&|! ]");
        List<String> list = new ArrayList<>();
        for (int i=0; i < arr.length; i++){
            if (arr[i].length() > 0) {
                list.add(arr[i]);
            }
        }
        String[] result = new String[list.size()];
        int index = 0;
        for (String str : list) {
            result[index++] = str;
        }


        data.setMode(0, ParseData.OR);
        int idx = 1;
        for (int i=0; i<query.length(); i++) {
            switch (query.charAt(i)) {
                case '&':
                    data.setMode(idx, ParseData.AND);
                    break;
                case '|':
                    data.setMode(idx, ParseData.OR);
                    break;
                case '!':
                    data.setMode(idx, data.getMode(idx) | ParseData.NOT);
                    break;
            }
        }

        data.setInput(result);
        return data;
    }
}