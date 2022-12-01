import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1A {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int max = 0;
            int count = 0;
            String line;

			while ((line = reader.readLine()) != null) {  
                if(line.equals("")) {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                } else {
                    count += Integer.parseInt(line);
                }
			}

			reader.close();

            System.out.println("El elfo que más calorías porta tiene: " + max + " calorías.");

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}