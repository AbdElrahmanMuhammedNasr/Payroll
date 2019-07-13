package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title> Payroll</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style_2.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"login\">\n");
      out.write("        <form action=\"mainservlet\" method=\"POST\">\n");
      out.write("          <input type=\"text\" name=\"username\" value=\"\" placeholder=\"User Name\">\n");
      out.write("          <input type=\"password\" name=\"password\" value=\"\" placeholder=\"Password\"><br><br>\n");
      out.write("          <hr>\n");
      out.write("          <input type=\"text\" name=\"code\" value=\"\" placeholder=\"Code\">\n");
      out.write("          <input type=\"text\" name=\"salary\" value=\"\" placeholder=\"Salary\">\n");
      out.write("          <input type=\"text\" name=\"previous\" value=\"\" placeholder=\"Pervious Pay\">\n");
      out.write("          <input type=\"text\" name=\"number\" value=\"\" placeholder=\"Number\">\n");
      out.write("          <input id=\"cl\" type=\"submit\" value=\"Calculate the Tax\">\n");
      out.write("       </form>\n");
      out.write("         <a id=\"help\" href=\"register.jsp\">Create Account</a>\n");
      out.write("      </div>\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/an.js\"></script>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
