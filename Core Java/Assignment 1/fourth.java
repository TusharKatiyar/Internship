import java.util.Scanner;

class fourth{

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        
        double payment;
        
        int i=1;
        while(i<=3){
            System.out.println("Enter hourly rate");
            double rate=input.nextDouble();

            System.out.println("Enter hours worked");
            double hrs_worked=input.nextDouble();
            
            if(hrs_worked<=40)
                payment=hrs_worked*rate;
            else    
                payment=40.0*rate + (hrs_worked-40)*rate*1.5;
            
            System.out.println("Gross Pay of Employee " + i + " is " + payment);

        }
    }
}