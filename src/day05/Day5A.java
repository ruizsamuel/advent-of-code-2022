package day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Day5A {

    public static void main(String[] args) {

        ArrayList <String> lines = new ArrayList<String>();
        ArrayList <Stack<Character>> stacks = new ArrayList<Stack<Character>>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) { 
                lines.add(line); 
            }

            reader.close();

        } catch (IOException e) {
            System.err.println(e);
        }

        for (int i = 0; i < 9; i++) {
            stacks.add(new Stack<Character>());
            for (int j = 0; j < lines.get(i).length(); j++) {
                stacks.get(i).add(lines.get(i).charAt(j));
            }
        }

        for (int i = 9; i < lines.size(); i++) {
            String line = lines.get(i);
            line = line.replaceAll("move ", "");
            line = line.replaceAll("from ", "");
            line = line.replaceAll("to ", "");

            String[] step = (line.split(" "));

            move (Integer.parseInt(step[0]), stacks.get(Integer.parseInt(step[1]) - 1), stacks.get(Integer.parseInt(step[2]) - 1));
        }

        String solution = "";
        for (Stack<Character> e : stacks) {
            solution += e.pop();
        }

        System.out.println("Solution: " + solution);
    }

    public static void move(int n, Stack<Character> ss, Stack<Character> ds) {
        for (int i = 0; i < n; i++) {
            ds.add(ss.pop());
        }
    }
}