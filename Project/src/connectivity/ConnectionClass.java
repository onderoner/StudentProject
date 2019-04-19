package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionClass {
    public static Connection connection;

    public static Connection getConnection(){
    /*  String dbname="emp";
      String username="root";
      String password="hype"; */
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&usetetimeCode=false&serverTimezone=Turkey",
                    "root","root");



        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}