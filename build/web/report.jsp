<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title> Payroll</title>
        <link rel="stylesheet" href="css/style_3.css">
    </head>
    <body>

        <% String x = (String) session.getAttribute("name");%>
        <% String y = (String) session.getAttribute("code");%>
        <% String z = (String) session.getAttribute("companyname");%>
        <% String a = (String) session.getAttribute("theTax");%>
        <% String b = (String) session.getAttribute("theSla");%>
        <% String d = (String) session.getAttribute("prev");%>
        <% String f = (String) session.getAttribute("job");%>
        <% String s = (String) session.getAttribute("theNat");%>
      

       




        <div class="calculate">


            <input id="data" type="text" name="" value="your new tax is : <%=a%>" disabled>
            <input id="data" type="text" name="" value="code is: <%=y%>" disabled>
            <input id="data" type="text" name="" value="companyname is: <%=z%>" disabled>
            <input id="data" type="text" name="" value="username is : <%=x%>" disabled>
            <input id="data" type="text" name="" value="your salary is: <%=b%>" disabled>
            <input id="data" type="text" name="" value="payed previous tax are: <%=d%>" disabled>
            <input id="data" type="text" name="" value="your job is: <%=f%>" disabled>
            <input id="data" type="text" name="" value="your natinality is: <%=s%>" disabled>

            <a id="Back" href="login.jsp">Back Home</a>

           
        </div>
    </body>
</div>
