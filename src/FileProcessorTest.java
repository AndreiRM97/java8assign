import org.junit.*;
import java.nio.file.*;
import java.io.*;

public class FileProcessorTest {

    private String testInputFilePath;
    private String testOutputFilePath = "test_output.txt";
    private int targetMonth = 5; // Example month

    @Before
    public void setUp() {
        testInputFilePath = "src/test/resources/test_input.txt";
    }

    @Test
    public void testProcessFile() throws IOException {
        FileProcessor processor = new FileProcessor();
        processor.processFile(testInputFilePath, targetMonth, testOutputFilePath);
    }

    @After
    public void cleanUp() throws Exception {
        Files.deleteIfExists(Paths.get(testOutputFilePath));
    }
}