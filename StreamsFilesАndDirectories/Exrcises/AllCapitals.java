package StreamsFilesАndDirectories.Exrcises;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Exercises Resources/input.txt";

        //Files.readAllLines(Path.of(path))
           //   .forEach(str -> System.out.println(str.toUpperCase()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //FileOutputStream outputStream = new FileOutputStream("output.txt");
        Files.readAllLines(Path.of(path))
                .forEach(str -> {
                    try {
                        writer.write(str.toUpperCase());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();

    }
}
