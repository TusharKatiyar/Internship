import java.io.*;
import java.util.*;

public class Question2
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintStream pw = new PrintStream("output.txt");

        try{

            char[][] letters = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
                {'J', 'K', 'L'},
                {'M', 'N', 'O'},
                {'P', 'R', 'S'},
                {'T', 'U', 'V'},
                {'W', 'X', 'Y'}
                
            };

            System.out.println("Enter a four-digit number: ");
            int number = sc.nextInt();
            int[] digits = new int[4];

            int i=3;
            while (number > 0) {
                digits[i] = number % 10;
                number /= 10;
                i--;
            }

            for(int d : digits){
                if(d == 0 || d == 1){
                    throw new Exception("Invalid number: Try again");
                }
            }

            printWords(digits, letters, pw, 0, ""); 

        } catch(Exception e){
            System.out.println(e.getMessage());
            main(args);

        } finally{
            sc.close();
            pw.close();
        }
    }

    public static void printWords(int[] digits, char[][] letters, PrintStream pw, int index, String word){

        if(index == digits.length){
            pw.format("%s%n",word);
            return;
        }
        for(int i=0; i<3; i++){
            printWords(digits, letters, pw, index+1, word + letters[digits[index]][i]);
        }
    }
}