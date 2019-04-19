package Login;
import java.sql.PreparedStatement;
import connectivity.ConnectionClass;
import java.sql.ResultSet;
import java.sql.*;
// import java.sql.SQLException;

public class LoginModel {

    Connection connection;

    public  LoginModel() {
        // try {
        this.connection = ConnectionClass.getConnection();
        //}
       /* catch (SQLDataException e){
            e.printStackTrace();
        } */
        if (this.connection == null) {
            System.exit(1);
        }


    }

    public boolean isDatabaseConnected() {
        return this.connection != null;
    }

    public boolean isLogin(String user, String password, String opt) throws Exception {

        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM log where userName=? AND password=? AND division=?";
        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, password);
            pr.setString(3, opt);

            rs = pr.executeQuery();



            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        } finally {
            {
                pr.close();
                rs.close();
            }

        }
    }
}