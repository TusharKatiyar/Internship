import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {
    public static void main(String args[]){

        Scanner input=new Scanner(System.in);
        int n=input.nextInt();

        ArrayList<Integer> ludic=new ArrayList<Integer>();

        for(int i=1;i<=n;i++){
            ludic.add(i);
        }

        for(int index=1;index<ludic.size();index++){

            int first=ludic.get(index);

            int rem=first+index;

            while(rem<ludic.size()){
                ludic.remove(rem);

                rem+=first-1;
            }
        }

        System.out.println(ludic);

    }
}
