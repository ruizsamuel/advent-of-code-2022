package day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4A {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int solution = 0;

			while ((line = reader.readLine()) != null) {
                String[] pair = line.split(",");
                int[][] sections = {{Integer.parseInt(pair[0].split("-")[0]), Integer.parseInt(pair[0].split("-")[1])}, 
                                    {Integer.parseInt(pair[1].split("-")[0]), Integer.parseInt(pair[1].split("-")[1])}};

                if (sections[1][0] >= sections[0][0] && sections[1][1] <= sections[0][1]) solution++;
                else if (sections[0][0] >= sections[1][0] && sections[0][1] <= sections[1][1]) solution++;
			}

			reader.close();
            System.out.println("Solution: " + solution);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}