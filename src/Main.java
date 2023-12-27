import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Main <inputFile> <targetMonth> <outputFile>");
            return;
        }

        FileProcessor processor = new FileProcessor();
        try {
            processor.processFile(args[0], Integer.parseInt(args[1]), args[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}