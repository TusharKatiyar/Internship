import java.util.Scanner;

public class Decrypt{
    public static void main(String[] args){    

        try (Scanner input = new Scanner(System.in)) {
            int number=input.nextInt();

            int[] digit=new int[4];

            for(int i=0;i<4;i++){
                digit[i]=number%10;
                number/=10;
            }

            int temp=digit[0];
            digit[0]=digit[2];
            digit[2]=temp;

            int temp1=digit[1];
            digit[1]=digit[3];
            digit[3]=temp1;

            
            for(int i=0;i<4;i++){
                    
                if(digit[i]>=7){
                        digit[i]=digit[i]-7;
                }
                else{
                    digit[i]=digit[i]+10-7;
                }
            }
        int decrypt=digit[3]*1000+digit[2]*100+digit[1]*10+digit[0];
        System.out.println("Decrypted number is: "+decrypt);
        }
    }
}
