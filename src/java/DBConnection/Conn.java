package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/software", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return con;
    }

}
