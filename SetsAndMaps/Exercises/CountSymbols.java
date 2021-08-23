package SetsAndMaps.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //символ -> брой срещанията
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        for (int index = 0; index <= text.length() - 1; index++) {
            char currentSymbol = text.charAt(index);
            //преброим
            //нямам такъв запазен символ
            if(!symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, 1);
            } else { //имам такъв запазен символ
                int currentCount = symbols.get(currentSymbol);
                symbols.put(currentSymbol, currentCount + 1);
            }

        }

        // {symbol}: {count} time/s
        for (Map.Entry<Character, Integer> entry: symbols.entrySet()) {
            //символ -> брой на срещанията
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }


    }
}
