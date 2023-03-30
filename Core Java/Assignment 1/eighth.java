import java.util.Scanner;

class eighth{
    public static void main(String[] args){

        long factorial=1;
            for(long i=1;i<=20;i++){
                factorial=factorial*i;
                System.out.println("Factorial of "+i+" is: "+factorial);
            }
    }
}