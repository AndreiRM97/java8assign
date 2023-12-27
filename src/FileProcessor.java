import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

public class FileProcessor {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void processFile(String inputFileName, int targetMonth, String outputFileName) throws IOException {
        Path inputFilePath = Paths.get("C:\\Users\\zenka\\Desktop\\sit\\java8assign", "data.txt");
        Path outputFilePath = Paths.get("C:\\Users\\zenka\\Desktop\\sit\\java8assign","dataFixed.txt");

        List<String> sortedLines = Files.lines(inputFilePath)
                .map(line -> line.split(","))
                .filter(parts -> parts.length >= 3 && isMonthEqual(parts[2], targetMonth))
                .map(parts -> new String[]{parts[0].trim(), parts[1].trim()})
                .sorted(Comparator.comparing((String[] arr) -> arr[1]).thenComparing(arr -> arr[0]))
                .map(arr -> arr[0] + ", " + arr[1])
                .collect(Collectors.toList());

        Files.write(outputFilePath, sortedLines);
    }

    private boolean isMonthEqual(String dateString, int targetMonth) {
        dateString = dateString.trim();
        LocalDate date = LocalDate.parse(dateString, FORMATTER);
        return date.getMonthValue() == targetMonth;
    }
}