package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllOperationInDB {
/////////////to inser data of deployer///////////////////////////////////////////

    public void insert(String nationality, String companyName, String job, String code, String salary, String userName, String password, String MorW) throws ClassNotFoundException, SQLException {
        try {
            Conn c = new Conn();
            Connection con = c.getConnection();
            System.out.println("nation = " + nationality);
            ///*****
            String s = "" ; 
            for(int i = 0 ; i < nationality.length() ; i++ ){
                s += Character.toUpperCase(nationality.charAt(i)) ; 
            }
            nationality = s ;
            System.out.println("nation2 = " + nationality);
            ////*****
            
            
            String query = "insert into register values (?, ?, ?, ?, ? , ? , ?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nationality);
            preparedStmt.setString(2, job);
            preparedStmt.setString(3, code);
            preparedStmt.setDouble(4, Double.parseDouble(salary));
            preparedStmt.setString(5, userName);
            preparedStmt.setString(6, password);
            preparedStmt.setString(7, MorW);
            preparedStmt.setString(8, companyName);
            preparedStmt.setString(9, "0");

            preparedStmt.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/////////////////////////////////////////to get data of deployer username,password,previous_tax//////////

    public String[] getData(String userName, String pass) {

        String nat = null, morw = null;
        String tax = null;
        String salary = null, job = null, code = null, username = null, companynam = null;
        try {
            Conn c = new Conn();
            Connection con = c.getConnection();

            String query = "select * from  register where UserName= '" + userName + "' and Password = '" + pass + "'";
            ResultSet r = con.createStatement().executeQuery(query);
            while (r.next()) {
                nat = r.getString(1);
                job = r.getString(2);
                code = r.getString(3);
                salary = r.getString(4);
                username = r.getString(5);
                morw = r.getString(7);
                companynam = r.getString(8);

                tax = r.getString(9);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] result = {nat, morw, tax, salary, job, code, username, companynam};
        return result;
    }

    ///////////////////////////////to update last taxse in regester table///////////////////////////////////////////////////// 
    public void insert(double t, String name) {

        try {

            Conn c = new Conn();
            Connection con = c.getConnection();

            String queryin = "update register set previous_taxes = " + t + " where UserName = '" + name + "' ";
            PreparedStatement preparedStmt = con.prepareStatement(queryin);

            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    /////////////////////////////////////////////////////////////////////////////////

}
