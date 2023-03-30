import java.util.Scanner;

class Third{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        int pos_num=0;
        int neg_num=0;
        int zero_num=0;

        for(int i=0;i<5;i++){
            int num=input.nextInt();
            if(num>0)
                pos_num++;
            else if(num<0)
                neg_num++;
            else 
                zero_num++;
        }
        
    System.out.println("Number of Positive numbers: "+pos_num);
    System.out.println("Number of Negitive numbers: "+neg_num);
    System.out.println("Number of Zeros: "+zero_num);
    }
}