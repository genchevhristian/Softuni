package StreamsFilesАndDirectories.Exrcises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("D:\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Exercises Resources/input.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (Exception io) {
            System.out.println("Another error with reading file");
        }
        //2. преброим гласни, съгласни, пунк. знаци

        Map<String, Integer> symbols = new HashMap<>();
        //гласни -> брой
        symbols.put("vowels", 0); //a e i o u
        //съгласни -> брой
        symbols.put("consonants", 0);
        //пунк.знаци -> брой
        symbols.put("punctuations", 0); //! , . ?

        for (String line : lines) {
            for (char symbol : line.toCharArray()) {
                if(symbol == ' ') {
                    continue;
                } else if (isVowel(symbol)) {
                    symbols.put("vowels", symbols.get("vowels") + 1);
                } else if (isPunctional(symbol)) {
                    symbols.put("punctuations", symbols.get("punctuations") + 1);
                } else {
                    symbols.put("consonants", symbols.get("consonants") + 1);
                }
            }
        }
        //3. print
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Vowels: " + symbols.get("vowels"));
        writer.newLine();
        writer.write("Consonants: " + symbols.get("consonants"));
        writer.newLine();
        writer.write("Punctuation: " + symbols.get("punctuations"));

        writer.close();

    }

    private static boolean isPunctional(char symbol) {
        //! , . ?

        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        //true -> гласна
        //false -> съгласна
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
