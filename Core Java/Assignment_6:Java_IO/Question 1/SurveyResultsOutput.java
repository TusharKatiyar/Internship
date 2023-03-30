import java.io.*;
import java.util.*;

public class SurveyResultsOutput {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in);
             Formatter output = new Formatter("numbers.txt")) {
            
            System.out.println("Enter all numbers for file: ");
            int number = input.nextInt();

            while (number != 0) {
                output.format("%d%n", number);
                number = input.nextInt();
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
