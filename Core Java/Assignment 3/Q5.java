import java.util.Scanner;

public class Q5 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();

        if(n%2!=0){
            for(int i=1;i<=n;i++){
                if(i<=n/2+1){
                    for(int j=n/2;j>=i;j--){
                      System.out.print(" ");
                    }
                    for(int k=1;k<=2*i;k++){
                        System.out.print("-");
                    }
                    System.out.println();
                }
                else{
                    for(int j=1;j<=i-n/2-1;j++){
                        System.out.print(" ");
                    }
                    for(int k=1;k<=2*(n-i+1);k++){
                        System.out.print("-");
                    }
                    System.out.println();
                }
            }
        }

        else{
            for(int i=1;i<=n;i++){
                if(i<=n/2){
                    for(int j=n/2-1;j>=i;j--){
                      System.out.print(" ");
                    }
                    for(int k=1;k<=2*i;k++){
                        System.out.print("-");
                    }
                    System.out.println();
                }
                else{
                    for(int j=1;j<=i-n/2-1;j++){
                        System.out.print(" ");
                    }
                    for(int k=1;k<=2*(n-i+1);k++){
                        System.out.print("-");
                    }
                    System.out.println();
                }
            }
        }
    }
}
