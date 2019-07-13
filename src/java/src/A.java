package src;

import DBConnection.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.lang.Exception;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class A {

   public  static boolean Cannot = false;

    private String monthORweak, country, code;
    private double salary, presalary;
    private int num;
    double result = 0.0, x = 0.0;

    public A(String monthORweak, String country, String code, double salary, double presalary, int num) {
        this.monthORweak = monthORweak;
        this.country = country;
        this.code = code;
        this.salary = salary;
        this.presalary = presalary;
        this.num = num;
    }

    public String getMonthORweak() {
        return monthORweak;
    }

    public void setMonthORweak(String monthORweak) {
        this.monthORweak = monthORweak;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPresalary() {
        return presalary;
    }

    public void setPresalary(double presalary) {
        this.presalary = presalary;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
//////check for input user (previous salary)/////////////

    private boolean checkInput() {
        double max = salary * (num - 1);
        double min = max * .8;
        if (presalary > max || presalary < min) {
            return false;
        }
        return true;
    }

    ///////////Operations//////////
    public String[] count() throws SQLException, ClassNotFoundException {
//////any statement sytem .out.print to Testing///////////////

        ////////////variable////////////
        String sermonth = "";
        String[] backFromC = null;
        //  String codeORwm = null;
        double total;
        double initVal;
        String stringCode = "";
        int intCode;
        int rem;
        int once;

        System.out.println("the  start of count in class A");
        if (!checkInput()) {
          return null;
        }
        /////check for nationality///////////
        sermonth += "a_" + monthORweak + num;

        total = salary + presalary;

        System.out.println("Total is " + total);

        initVal = (monthORweak.equals("month") ? 416.67 : 96.16);

        try {
            System.out.println(sermonth);
            Connection con = Conn.getConnection();

                for (int i = 0; i < code.length(); i++) {
                    if (code.charAt(i) <= '9') {
                        stringCode += code.charAt(i);
                    }
            }

            intCode = Integer.parseInt(stringCode);
////////////check for code if more than 500 or no and operate with it ///////////////
            if (intCode > 500) {
                rem = intCode % 500;
                //////number of operate////////
                once = intCode / 500;
                result = once * initVal * num;
                ResultSet rs = con.createStatement().executeQuery("select * from " + sermonth + " where code=" + rem);
                while (rs.next()) {
                    x = Double.parseDouble(rs.getString(2));
                }
                result += x;

            } else {
                ///////////////testing/////////////////////////
                System.out.println("i am in else condition");
                //  System.out.println("the var ars " + sermonth + " and" + codeORwm + " " + intCode);
                ////////////////////////////////////////////

                ResultSet rs = con.createStatement().executeQuery("select * from " + sermonth + " where code=" + intCode);
                while (rs.next()) {
                    x = Double.parseDouble(rs.getString(2));
                }
                result += x;
            }
            /////////testing////////////////////////
            System.out.println("the result is class a " + result);
            /////////////////////////////////////

            /////to sub (previostatal - value of class A)//////////////////
            total -= result;

            /////////testing////////////////////////
            System.out.println("the total  is after class a " + total);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        /////////testing////////////////////////
        System.out.println("before call Class C");

        ///////to call work on class C////////
        backFromC = new C().Run(total, monthORweak, num, country);

        return backFromC;
    }

}
