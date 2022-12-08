package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day8A {

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

            int solution = 4*SIZE - 4;
            for (int i = 1; i < SIZE - 1; i++) {
                for (int j = 1; j < SIZE - 1; j++) {
                    if (isVisible(i,j)) {
                        solution += 1;
                    }
                }
            }

            System.out.println("Solution: " + solution);

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static boolean isVisible(int i, int j) {
        int h = map[i][j];
        int visible = 4;

        for (int n = j -1 ; n >= 0; n--) {
            if (map[i][n] >= h) {visible--; break;}
        }
        for (int n = j + 1; n < SIZE; n++) {
            if (map[i][n] >= h) {visible--; break;}
        }
        for (int n = i - 1; n >= 0; n--) {
            if (map[n][j] >= h) {visible--; break;}
        }
        for (int n = i + 1; n < SIZE; n++) {
            if (map[n][j] >= h) {visible--; break;}
        }

        return (visible > 0);
    }
}