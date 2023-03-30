import java.util.Scanner;  

public class Second {      
    
    public static void main(String[] args) {         
        
        Scanner input = new Scanner(System.in);         
        
        System.out.print("Enter a positive integer: ");         
        int n = input.nextInt();         
        
        int[] arr=new int[5];        
        
        int i=0,digit;
        while (n > 0) {             
            digit=n%10;
            arr[i]=digit;
            n/=10;
            i++;
        }         
        
        System.out.println(arr[4]+"   "+arr[3]+"   "+arr[2]+"   "+arr[1]+"   "+arr[0]);     
    } 
} 