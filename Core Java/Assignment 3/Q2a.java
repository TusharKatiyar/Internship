import java.util.Scanner;

public class Q2a {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();

        String first = "";
        int i=0;
    
        while(str.charAt(i)!=' '){
            first+=str.charAt(i);
            i++;
        }
        

        String last="";
        int j=str.length()-1;
        
        while(str.charAt(j)!=' '){
            last=str.charAt(j)+last;
            j--;
        }

        System.out.print(last);

        for(int k=j;k>=i;k--){
            System.out.print(str.charAt(k));
        }

        System.out.println(first);
        
    }
}
