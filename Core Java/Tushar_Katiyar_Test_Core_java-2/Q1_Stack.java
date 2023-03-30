import java.util.*;

class Stack{
    
        private int[] stack;
        private int top;
        private int size;
    
        // Constructor
        public Stack(int size) {
            this.size = size;
            stack = new int[size];
            top = -1;
        }
        
        // Methods
        public void push(int element) {
            if (top == size - 1) {
                System.out.println("Stack Overflow");
            } else {
                top++;
                stack[top] = element;
            }
        }

        // Pop method
        public int pop() {
            if (top == -1) {
                return -1;
            } else {
                int element = stack[top];
                top--;
                return element;
            }
        }
    
        // Peek method
        public int peek() {
            if (top == -1) {
                return -1;
            } else {
                return stack[top];
            }
        }
    
        // isEmpty method
        public boolean isEmpty() {
            return top == -1;
        }
}


public class Q1_Stack {

    private static void sort(Stack stack) {

        if (!stack.isEmpty()) {                                 // If the stack is not empty
            int temporary = stack.pop();                        // Pop the top element of the stack
            sort(stack);                                        // Call the sort method
            orderInsertion(stack, temporary);                   // Call the orderInsertion method
        }

    }

    private static void orderInsertion(Stack stack, int temporary) {

        // If the temporary variable is greater than the top element of the stack or the stack is empty\

        if (temporary > stack.peek() || stack.isEmpty()) 
            stack.push(temporary);                              // Push the temporary variable into the stack
        
        else {
            int ans = stack.pop();                              // Pop the top element of the stack
            orderInsertion(stack, temporary);                   // Call the orderInsertion method
            stack.push(ans);                                    // Push the popped element into the stack
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);                  // Create a Scanner object
        System.out.print("Enter the number of test cases: ");
        int t = input.nextInt();                                 // Store the number of test cases in the variable t
 
        try {

            for(int i=0;i<t;i++){

                System.out.print("Enter the number of elements: "); // Prompt the user to enter the number of elements
                int size = input.nextInt();                         // Store the number of elements in the variable size

                Stack stack = new Stack(size);                      // Create a stack object
                System.out.print("Enter the elements: ");           // Prompt the user to enter the elements

                for(int j = 0; j < size; j++) {
                    stack.push(input.nextInt());                    // Push the elements into the stack
                }

                System.out.println("Original Stack: " + stack);     // Print the original stack
                sort(stack);                                        // Call the sort method

                System.out.println("Sorted Stack: " + stack);       // Print the sorted stack   
                System.out.println();

            } 
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());         //printing the error message

        } finally {
            input.close();                                          //closing the scanner
        }
    }
}