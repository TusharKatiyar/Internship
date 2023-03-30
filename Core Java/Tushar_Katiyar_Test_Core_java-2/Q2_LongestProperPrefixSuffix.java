import java.util.*;

public class Q2_LongestProperPrefixSuffix {

    private static int solver(String string) {

        int str_len = string.length();

        if(str_len < 2) {
            return 0;
        }

        int i = 1;
        int j = 0;

        // Loop to find the length of the longest proper prefix which is also a proper suffix
        while (i < str_len) {
            
            // If the characters at the ith and jth index are equal, increment i and j
            if (string.charAt(i) == string.charAt(j)) { 
                ++i;
                ++j;
            } 
            
            // If the characters at the ith and jth index are not equal, increment i and set j to 0
            else {
                i = i - j + 1; 
                j = 0;
            }
        }
        
        // Return the length of the longest proper prefix which is also a proper suffix
        return j; 
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);                 // Create a Scanner object
        System.out.print("Enter number of test cases: ");
        int t = input.nextInt();                                // Store the number of test cases in the variable t

        try {     
        
            for(int i=0;i<t;i++){
                   
                System.out.print("Enter the string: ");         // Prompt the user to enter the string
                String string = input.next();                   // Store the string in the variable string

                // Print the length of the longest proper prefix which is also a proper suffix
                System.out.println("Length of the longest proper prefix which is also a proper suffix: " + solver(string)); 

                System.out.println();
            }   

        } catch(Exception e) {
            System.out.println(e);                          // Print the exception

        } finally {
            input.close();                                  // Close the Scanner object
        }
    }
}

