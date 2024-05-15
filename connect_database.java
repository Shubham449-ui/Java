
package connectmysql;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;


public class ConnectMySQL {

   
    public static void main(String[] args) throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the student name :: ");
            String name = sc.nextLine();
            
            System.out.println("Enter the student id :: ");
            int id = sc.nextInt();
            sc.nextLine();
            
            
            System.out.println("Enter the age ");
            int age = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Enter the Department :: ");
            String dept = sc.nextLine();
            
            System.out.println("Enter the City :: ");
            String city = sc.next();
            
            System.out.println("Enter the sex :: ");
            String s = sc.next();
            
            System.out.println("Enter the date of admission (yy-mm-dd):: ");
            String d = sc.next();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("","","");// Here you have to put your database url,user,password
            System.out.println(con);
            
            PreparedStatement ps = con.prepareStatement("insert into (Whatever is your table name) values(?,?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, dept);
            ps.setString(5, city);
            ps.setString(6, s);
            ps.setString(7, d);
            
            
            
            int i = ps.executeUpdate();
            if(i>0)
            {
                System.out.println("Success");
            }
            else
            {
                System.out.println("Fail");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
