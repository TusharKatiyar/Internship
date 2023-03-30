import java.util.Scanner;

public class Encrypt{
    public static void main(String[] args){ 
               
        try (Scanner input = new Scanner(System.in)) {
            int number=input.nextInt();

            int[] digit=new int[4]; 
            if(number>1000 && number <=9999){
                for(int i=0;i<4;i++){
                    digit[i]=number%10;
                    int temp=digit[i]+7;
                    digit[i]=temp%10;
                    number/=10;
                }
                int temp=digit[0];
                digit[0]=digit[2];
                digit[2]=temp;

                int temp1=digit[1];
                digit[1]=digit[3];
                digit[3]=temp1;
            }
            int encrypt=digit[3]*1000+digit[2]*100+digit[1]*10+digit[0];
            System.out.println("Encrypted Number is: " +encrypt);
        }
    }
}