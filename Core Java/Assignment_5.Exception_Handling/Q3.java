//Create a user defined exception to check whether your employee exist in your data structure (use any data structure to store the employees - like array, ArrayList etc) and throw exception if name is not in the employees list. Use the catch and finally block to make an appropriate handling.

import java.util.ArrayList;
import java.util.Scanner;

class NameNotFoundException extends Exception
{
    NameNotFoundException(String s)
    {
        super(s);
    }
}

class Employee
{
    String name;
    int id;
    Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
}

public class Q3
{
    public static void main(String[] args)
    {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Tushar", 1));
        employees.add(new Employee("Rishabh", 2));
        employees.add(new Employee("Saksham", 3));
        employees.add(new Employee("Bhavya", 4));
        employees.add(new Employee("Yogesh", 5));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the employee: "); 
        String input = sc.nextLine();

        try
        {
            boolean flag = false;
            for(Employee e: employees)
            {
                if(e.name.equals(input))
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
                System.out.println("Employee found");
            else
                throw new NameNotFoundException("Employee not found");
        
        }
        catch(NameNotFoundException e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Finally block executed");
            sc.close();
        }
    }
}