//export CLASSPATH=mysql-connector-j-8.0.32.jar:.

import java.sql.*;
import java.util.*;

class Employee
{
    int id;
    String name;
    int age;
    
    Employee(int id, String name, int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }
}

public class Details
{    
    public static void main(String[] args)
    {
        try
        {

            ArrayList<Employee> list=new ArrayList<Employee>();
            list.add(new Employee(1,"ABC",35));
            list.add(new Employee(2,"DEF",22));
            list.add(new Employee(3,"HIJ",40));
            list.add(new Employee(4,"KLM",21));
            list.add(new Employee(5,"NOP",25));
            list.add(new Employee(6,"QRS",21));
            list.add(new Employee(7,"TUV",22));
            list.add(new Employee(8,"WXY",21));
            list.add(new Employee(9,"ZAB",30));
            list.add(new Employee(10,"CDE",25));

            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","password");
            Statement statement=connection.createStatement();
            System.out.println("Database Connected");
            
            for(int i=0;i<list.size();i++){
                String str="INSERT INTO  Employee VALUES("+list.get(i).id+","+"'"+list.get(i).name+"'"+","+list.get(i).age+")";
                int rows=statement.executeUpdate(str);
            }

            ResultSet resultSet=statement.executeQuery("SELECT * FROM Employee ORDER BY Age");
          
            while(resultSet.next())
            {
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}