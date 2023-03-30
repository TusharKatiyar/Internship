import java.io.*;
import java.util.*;

public class SurveyResultsInput {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("numbers.txt"));
             Formatter output = new Formatter("output.txt")) {
            
            int number = input.nextInt();
            output.format("%d%n", number);
            
            while (input.hasNext()) {
                number = input.nextInt();
                output.format("%d%n", number);
            }            
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}