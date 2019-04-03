import java.util.HashMap;
import java.util.Map;

public class ParseData {

    public final static int DEFAULT = 1;
    public final static int AND = 2;
    public final static int OR = 4;
    public final static int NOT = 8;

    private String[] input;
    private int[] modes;
    private Map<Integer, Integer> modeMap = new HashMap<>();

    public void setInput(String[] strs) {
        input = strs;
    }

    public void setModes(int[] modes) {
        this.modes = modes;
    }

    public String[] getInput() {
        return input;
    }

    public int[] getModes() {
        return modes;
    }

    public void setMode(int index, int value) {
        modeMap.put(index, value);
    }

    public int getMode(int index) {
        return modeMap.get(index);
    }
}
