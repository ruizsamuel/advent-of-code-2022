package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3A {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int solution = 0;

			while ((line = reader.readLine()) != null) {  
                int size = line.length() / 2;
                ArrayList<Character> list = new ArrayList<Character>();
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (line.charAt(i) == line.charAt(j + size)) {
                            if (!list.contains(line.charAt(i))) {
                                list.add(line.charAt(i));
                            }
                        }
                    }
                }
                
                for (char e : list) {
                    if (e >= 97) {
                        solution += e - 96;
                    } else {
                        solution += e - 38;
                    }
                }
			}
			reader.close();

            System.out.println("Solution: " + solution);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}