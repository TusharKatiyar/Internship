import java.util.Scanner;

class fifth{
    public static void main(String[] args){

        Scanner input=new Scanner(System.in);

        System.out.println("Enter a number between 1 and 20");

        int side=input.nextInt();

        for(int i=0;i<side;i++){
            if(i==0 || i==side-1){
                for(int j=0;j<side;j++){
                    System.out.print("*");
                }
            }
            else{
                System.out.print("*");

            for(int j=0;j<side-2;j++){
                System.out.print(" ");
            }
            System.out.print("*");
            }
            System.out.println();
        }
    }
}