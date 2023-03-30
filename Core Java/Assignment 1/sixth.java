import java.util.Scanner;

class sixth{

    public static void main(String[] args){

        Scanner input=new Scanner(System.in);
        int number=input.nextInt();

        int num=number;
        int digits=0;
        while(num!=0){
            num=num/10;
            digits++;
        }

        if(digits!=5){
            System.out.println("There is an Error");
            System.out.println("Give new number");
            number=input.nextInt();
        }

        int original=number;
        int reversed=0;

        int digit;
        while(number!=0){
            digit = number%10;
            reversed = reversed*10 + digit;
            number/=10;
        }

        if(original==reversed){
            System.out.println("Number is a palindrome");
        }
        else{
            System.out.println("Number is not a palindrome");
        }
    }
}