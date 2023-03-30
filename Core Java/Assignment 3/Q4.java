import java.util.Scanner;
import java.util.Arrays;

public class Q4 {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        String str1=input.nextLine();
        String str2=input.nextLine();

        str1=str1.replaceAll("\\p{Punct}|\\p{Space}", "");

        str2=str2.replaceAll("\\p{Punct}|\\p{Space}", "");
      
        char[] arr1=str1.toCharArray();
        Arrays.sort(arr1);

        char[] arr2=str2.toCharArray();
        Arrays.sort(arr2);

        int i=0;
        for(;i<arr1.length;i++){
            if(arr1[i]==arr2[i]){
                continue;
            }
            else{
                System.out.println("Given Strings are not Anagram of each other");
                break;
            }
        }

        if(i==arr1.length){
            System.out.println("Given Strings are Anagram of each other");
        }
    }
}

//input
//Mother In

//output
//Given Strings are Anagram
