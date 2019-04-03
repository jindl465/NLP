public class ResultData implements Comparable<ResultData> {
    public String fileName;
    public int count = 0;
    public boolean invalid = false;

    @Override
    public int compareTo(ResultData d) {
        if (count < d.count) {
            return 1;
        } else if (count > d.count) {
            return -1;
        }
        return 0;
    }
}
