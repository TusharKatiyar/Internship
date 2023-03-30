import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
        System.out.println("The string is " + (isPalindrome(s) ? "a palindrome" : "not a palindrome"));
        input.close();
    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stack.push(Character.toLowerCase(s.charAt(i)));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                if (Character.toLowerCase(s.charAt(i)) != stack.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}