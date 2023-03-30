import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str=input.nextLine();

        String hex="";

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int in=(int)ch;

            hex+=Integer.toHexString(in);
        }
        System.out.println(hex);
    }
}
