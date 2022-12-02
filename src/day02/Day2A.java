package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2A {

    public static final int[][] matrix = {{3,6,0},{0,3,6},{6,0,3}};

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int score = 0;
			while ((line = reader.readLine()) != null) {
                int a = line.charAt(0) - 65;
                int b = line.charAt(2) - 88;

                score += matrix[a][b] + b + 1;

			}
			reader.close();

            System.out.println("Solution: " + score);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}