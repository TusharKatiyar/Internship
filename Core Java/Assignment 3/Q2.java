import java.util.Scanner;

public class Q2 {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        String[] arr = str.split(" ");

        String temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        String mid = "";
        for (int i = 1; i < arr.length - 1; i++) {
            mid += arr[i] + " ";
        }

        String rev = "";
        for (int i = mid.length() - 1; i >= 0; i--) {
            rev += mid.charAt(i);
        }

        System.out.println(arr[0] +rev + " " + arr[arr.length - 1]);
    }
}
