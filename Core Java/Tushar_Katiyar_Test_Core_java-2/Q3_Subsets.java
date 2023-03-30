import java.util.*;

public class Q3_Subsets {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> array) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();     // output array
        ArrayList<Integer> present = new ArrayList<Integer>();                          // present array
        Collections.sort(array);                                                        // sorting the array
        solver(array, output, present, 0);                                       // calling the solver function
        return output;

    }

    public static void solver(ArrayList<Integer> array, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> present, int index) {

        output.add(new ArrayList<Integer>(present));                // adding the present array to the output array
        for (int i = index; i < array.size(); i++) {                // looping through the array
            if (i != index && array.get(i) == array.get(i - 1)) {   // if the element is repeated
                continue;
            }
            present.add(array.get(i));                              // adding the element to the present array
            solver(array, output, present, i + 1);                  // calling the solver function
            present.remove(present.size() - 1);                     // removing the last element from the present array
        }
    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);                     // creating a scanner object
        System.out.print("Enter number of test cases: ");
        int t = input.nextInt();                                    // storing the number of test cases in the variable t

        try {  
        
                for(int i=0;i<t;i++){            

                System.out.print("Enter the number of elements: ");
                int size = input.nextInt();                             // storing the number of elements in the variable size
                System.out.print("Enter the elements: ");
                
                ArrayList<Integer> array = new ArrayList<Integer>();    // creating an arraylist object

                for(int j=0;j<size;j++){
                    array.add(input.nextInt());                         // adding the elements to the arraylist
                }
                System.out.print("The subsets are: ");
                System.out.println(subsets(array));                     // printing the subsets

                System.out.println();
            } 

        } catch (Exception e) {
            System.out.println(e);                                      // printing the exception

        } finally{
            input.close();                                              // closing the scanner object
            
        }
    }
}

