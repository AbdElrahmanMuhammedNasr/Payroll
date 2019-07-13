package src;

import DBConnection.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C {

    public static String[] Run(double total, String monthORWeak, int number, String country) throws SQLException, ClassNotFoundException {
        ////////////////////////Variable//////////////////////////

        String finalResult = null;
        Connection con = Conn.getConnection();
        double col1 = 0.0, col2 = 0.0, col3 = 0.0, col5 = 0.0;
        String table2 = null;
        int f = 0;
        String Userclass = null;
        int val;
        String len;
        double tot_d1 = 0.0;
        int first;
        int trueVal;

        /////key is number to work///////
        String table = "", key = "";

        ///// Testing///////
        System.out.println("line 1");

        if (monthORWeak.equals("month") && country .equals("UK")) {
            table = "monthly_paid";
            key = "month";
        } else if (monthORWeak.equals("week") && country.equals("UK")) {
            table = "weekly_paid";
            key = "week";
        } else if (monthORWeak.equals("month") && !country.equals("UK")) {
            table = "c_monthly_sc";
            key = "month";
        } else if (monthORWeak.equals("week") && !country.equals("UK")) {
            table = "c_weekly_sc";
            key = "week";
        }
        ///// Testing///////
        System.out.println("line 2");
        //////ssesion
        System.out.println("the table and the key" + table + " " + key);
        ///////////////////////
        ResultSet rs = con.createStatement().executeQuery("select * from " + table + " where " + key + "=" + number);

        ///////coulom of table C ////////
        while (rs.next()) {
            col1 = Double.parseDouble(rs.getString(2));
            col2 = Double.parseDouble(rs.getString(3));
            col3 = Double.parseDouble(rs.getString(4));
            col5 = Double.parseDouble(rs.getString(6));
        }
        /////Testing/////////////
        System.out.println("line 3");

////////////////////////////uk//////////////////////////////////////
        if (total <= col1 && country.equals("UK")) {
            table2 = "t_b";
            f = 0;
            Userclass = "Class A Result = "+total+" Class c valueCheck = "+col1+"Class B = ";

        } else if (total > col1 && total <= col2 &&country.equals("UK")) {
            table2 = "table_d1";
            f = 1;
            Userclass = "Class A Result = "+total+" Class c valueCheck = "+col1+"Class C -D1 = ";
        } else if (total > col1 && country.equals("UK")) {
            table2 = "table_d2";
            f = 2;
            Userclass = "Class A Result = "+total+" Class c valueCheck = "+col1+"Class C -D2 = ";
        } /////////////////////////////////sc//////////////////////////////////
        else if (total <= col1 && !country.equals("UK")) {
            table2 = "t_b_sc";
            f = 0;
            Userclass = "Class A Result = "+total+" Class c valueCheck = "+col1+"Class B = ";

        } else if (total > col1 && total <= col2 && !country.equals("UK")) {
            table2 = "table_d1_sc";
            f = 1;
            Userclass = "Class A Result = "+total+" Class c valueCheck = "+col1+"Class C -D1 SC = ";
        } else if (total <= col1 && !country.equals("UK")) {
            table2 = "table_d2_sc";
            f = 2;
            Userclass = "Class A Result = "+total+" Class c valueCheck = "+col1+"Class C -D2 SC = ";
        }
        
        //////sssesion
        System.out.println("the total in class c " + total);

//////////////////////////////////////////////////////////////////////////////////////////////
        val = (int) total;
        len = String.valueOf(val);

        //////testing////////////////
        System.out.println("the total value" + (len));

        int longval = len.length(), i = 0;

        System.out.println("the true value ");

        while (longval > 0) {
            //////testing//////////////
            System.out.println("i am  in while loop");
            System.out.println("what is going on");
            /////////////////////////////////

            first = Integer.parseInt(String.valueOf(len.charAt(i)));
            //////testing//////////////
            System.out.println("what is first " + first);
            ///////////////////////////////////

            trueVal = (int) (first * Math.pow(10.0, (double) (len.length() - (i) - 1)));

            //////testing//////////////
            System.out.println("the table is " + table2 + " and value " + trueVal);
            //////////////////////////

            ResultSet rs2 = con.createStatement().executeQuery("SELECT * FROM " + table2 + " WHERE total_texable =" + trueVal);

            //////testing//////////////
            System.out.println("the query to get value ");
           ///////////////////////////
            while (rs2.next()) {
                ///sseeeeion
         
                tot_d1 += Double.parseDouble(rs2.getString(2));
                System.out.println("the total from table " + tot_d1);
            }
            i++;
            longval--;
            rs2.close();
        }
                        Userclass += tot_d1 ; 

        System.out.println("line 4 after select from db");
        if (f == 0) {
            finalResult = String.valueOf(tot_d1);
        } else if (f == 1) {
            finalResult = String.valueOf(tot_d1 + col3);
        } else if (f == 2) {
            finalResult = String.valueOf(tot_d1 + col5);
        }

        System.out.println("end");
        ///////return name of class work and resultof tax///////
        String[] back = {finalResult, Userclass};
        return back;
    }

}
