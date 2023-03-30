import java.util.*;

public class Q5_wordBreak {

    public static int check(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);     // Create a HashSet object to store the words in the dictionary

         // dp[i] represents whether the substring s[0, i - 1] can be segmented into words in the dictionary
        int[] dp = new int[s.length() + 1];   
        dp[0] = 1;                                  // The empty string can be segmented into words in the dictionary

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                // If the substring s[0, j - 1] can be segmented into words in the dictionary and the 
                //substring s[j, i - 1] is in the dictionary
                if (dp[j]==1 && set.contains(s.substring(j, i))) {
                    dp[i] = 1;                     // The substring s[0, i - 1] can be segmented into words in the dictionary
                    break;                            // Break the inner loop
                }
            }
        }

        // Return whether the substring s[0, s.length() - 1] can be segmented into words in the dictionary
        return dp[s.length()];   

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);                         // Create a Scanner object

        System.out.print("Enter the number of test cases: ");
        int t= input.nextInt();                                         // t is the number of test cases

        try{

            for(int i=0;i<t;i++)
            {
                System.out.print("Enter the number of words in the dictionary: ");
                int n = input.nextInt();                                    // n is the number of words in the dictionary

                List<String> wordDict = new ArrayList<>();    // Create an ArrayList object to store the words in the dictionary

                System.out.println("Enter the words in the dictionary: ");
                for(int j=0;j<n;j++){
                    wordDict.add(input.next());                             // Add the words in the dictionary
                }

                System.out.print("Enter the string: ");
                String s = input.next();                                    // s is the input string

                // Calling method and printing whether the input string can be segmented into words in the dictionary 
                System.out.println(check(s, wordDict));        
                System.out.println();


            }
        }
        catch(Exception e){
            System.out.println(e);                                      // Print the exception
        }
        finally{
            input.close();                                              // Close the Scanner object
        }
    }
}
