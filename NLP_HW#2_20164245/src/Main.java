import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        System.out.println("Enter the word you want to find");
        System.out.println("exit!! : Terminate program.");
        while (true) {
            String input = scanner.nextLine();
            if ("exit!!".equals(input)) {
                break;
            }
            fileManager.getCountInEachFile(parser.parse(input));
            System.out.println();
        }
    }
}
