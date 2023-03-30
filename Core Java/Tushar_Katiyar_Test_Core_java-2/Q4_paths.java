import java.util.*;

public class Q4_paths {
    
    public static int allPaths(int m, int n) {

        int[][] dp = new int[m][n];         // dp[i][j] represents the number of paths to reach the cell (i, j)

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;                   // There is only one path to reach any cell in the first row
        }
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;                   // There is only one path to reach any cell in the first column
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // The number of paths to reach the cell (i, j) is the sum of the number of paths 
                //to reach the cell (i - 1, j) and the number of paths to reach the cell (i, j - 1)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
            }
        }

        return dp[m - 1][n - 1];            // Return the number of paths to reach the cell (m - 1, n - 1)
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);                         // Create a Scanner object

        System.out.print("Enter the number of test cases: ");
        int t= input.nextInt();                                         // t is the number of test cases

        try{

            for(int i=0;i<t;i++)
            {
                System.out.print("Enter the number of rows: ");
                int m = input.nextInt();                                    // m is the number of rows

                System.out.print("Enter the number of columns: ");
                int n = input.nextInt();                                    // n is the number of columns

                System.out.println(allPaths(m, n));                       // Calling method and printing the number of paths
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