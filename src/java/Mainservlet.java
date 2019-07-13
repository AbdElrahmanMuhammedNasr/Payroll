
import DBConnection.AllOperationInDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.A;
import static src.A.*;

@WebServlet("/mainservlet")
public class Mainservlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("national = " + request.getParameter("nat"));
        try {
            new AllOperationInDB().insert(
                    request.getParameter("nat"),
                    request.getParameter("com"),
                    request.getParameter("jo"),
                    request.getParameter("co"),
                    request.getParameter("sa"),
                    request.getParameter("un"),
                    request.getParameter("pa"),
                    request.getParameter("MonthOr"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            //////to get deployer info username,pass,previoustax///////////////
            String[] result = new AllOperationInDB().getData(request.getParameter("username"), request.getParameter("password"));
            System.out.println(result[0] + " " + " " + result[1]);
            String username = request.getParameter("un");
            String[] tax = new A(
                    result[1],
                    result[0],
                    request.getParameter("code"),
                    Double.parseDouble(request.getParameter("salary")),
                    Double.parseDouble(request.getParameter("previous")),
                    Integer.parseInt(request.getParameter("number"))
            ).count();
            ////////ta add new tax to previous tax//////////////////////////////////
            double res = Double.parseDouble(result[2]) + Double.parseDouble(tax[0]);

            System.out.println("the tax is  " + tax[0]);
            //////////////////////to add tax after add new tax///////////////////////////
            new AllOperationInDB().insert(res, username);

            ///////////////////////////////////to display details////////////////////////////
            session.setAttribute("name", request.getParameter("username"));
            session.setAttribute("theTax", String.valueOf(tax[0]));
            session.setAttribute("theClass", String.valueOf(tax[1]));
            session.setAttribute("theNat", result[0]);
            session.setAttribute("theSla", result[3]);
            session.setAttribute("thenumber", request.getParameter("number"));
            session.setAttribute("prev", String.valueOf(res));
            session.setAttribute("job", result[4]);
            session.setAttribute("code", result[5]);
            session.setAttribute("companyname", result[7]);

            ////////////////////////////////////////////////////////
            request.getRequestDispatcher("calculateTax_1.jsp").forward(request, response);
            //response.sendRedirect("calculateTax.jsp");      
        } catch (Exception r) {
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

}
