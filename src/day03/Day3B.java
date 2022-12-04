package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3B {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int solution = 0;

            ArrayList<ArrayList<Character>> lines = new ArrayList<ArrayList <Character>>();

			while ((line = reader.readLine()) != null) { 
                ArrayList<Character> chars = new ArrayList<Character>();
                for (int i = 0; i < line.length(); i++) {chars.add(line.charAt(i));} 
                lines.add(chars);
			}
			reader.close();

            for (int i = 0; i < lines.size(); i+=3) {
                for (char e : lines.get(i)) {
                    if (lines.get(i+1).contains(e) && lines.get(i+2).contains(e)) {
                        if (e >= 97) {
                            solution += e - 96;
                        } else {
                            solution += e - 38;
                        }
                        break;
                    }
                }
            }

            System.out.println("Solution: " + solution);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}