import java.util.Scanner;

class First {
	public static void main(String args[]) {
		
		Scanner input=new Scanner(System.in);

		int x=input.nextInt();
		int y=input.nextInt();
		
		if(x>y)
			System.out.println(x + " is larger");
		else if(y>x)
			System.out.println(y + " is larger");
		else
			System.out.println("These numbers are equal");
	}
}