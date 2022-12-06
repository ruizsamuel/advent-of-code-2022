package day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6B {

    public static final int N = 14;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
			reader.close();

            for (int i = N - 1; i < line.length(); i++) {
                ArrayList<Character> aux = new ArrayList<Character>();
                for (int j = 0; j < N; j++) {
                    if(!aux.contains(line.charAt(i - j))) {
                        aux.add(line.charAt(i - j));
                    } else {
                        break;
                    }
                }
                
                if (aux.size() == N) {
                    System.out.println("Solution: " + (i + 1));
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}