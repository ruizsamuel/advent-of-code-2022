package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day8B {

    public static final int SIZE = 99;

    static int[][] map = new int[SIZE][SIZE];

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
            reader.close();

            int solution = 0;
            for (int i = 1; i < SIZE - 1; i++) {
                for (int j = 1; j < SIZE - 1; j++) {
                    if (scenicScore(i,j) > solution) {
                        solution = scenicScore(i,j);
                    }
                }
            }

            System.out.println("Solution: " + solution);

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static int scenicScore(int i, int j) {
        int h = map[i][j];
        int score = 1;
        for (int n = 1 ; j - n >= 0; n++) {
            if (map[i][j - n] >= h) {score *= n; break;}
            if (j == n) score *= n;
        }
        for (int n = 1; j + n < SIZE; n++) {
            if (map[i][j + n] >= h) {score *= n; break;}
            if (j + n == SIZE - 1) score *= n;
        }
        for (int n = 1; i - n >= 0; n++) {
            if (map[i - n][j] >= h) {score *= n; break;}
            if (i == n) score *= n;
        }
        for (int n = 1; i + n < SIZE; n++) {
            if (map[i + n][j] >= h) {score *= n; break;}
            if (i + n == SIZE - 1) score *= n;
        }

        return score;
    }
}