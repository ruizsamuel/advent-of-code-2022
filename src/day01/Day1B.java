package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1B {
    
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int count = 0;
            String line;

            ArrayList <Integer> list = new ArrayList<Integer>();

            while ((line = br.readLine()) != null) {
                if(line.equals("")) {
                    list.add(count);
                    count = 0;
                } else {
                    count += Integer.parseInt(line);
                }
            }

            Collections.sort(list, Collections.reverseOrder());

            System.out.println("Solution: " + (list.get(0) + list.get(1) + list.get(2)));

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}