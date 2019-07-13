<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title> Payroll</title>
        <link rel="stylesheet" href="css/style_1.css">
    </head>
    <body>

        <% String x = (String) session.getAttribute("theTax");%>
        <% String y = (String) session.getAttribute("theClass");%>
        <% String z = (String) session.getAttribute("theNat");%>
        <% String a = (String) session.getAttribute("theSla");%>
        <% String b = (String) session.getAttribute("thenumber");%>
        <% String d = (String) session.getAttribute("prev");%>




        <div class="calculate">
            <P> Your Tax is </p>
            <input type="text" name="theTax" value="<%=x%>" disabled>
            <p> more details</p>
            <input id="data" type="text" name="" value="Class we work is: <%=y%>  " >
            <input id="data" type="text" name="" value="your Nationalty: <%=z%>  " disabled>
            <input id="data" type="text" name="" value="your salary is: <%=a%>  " disabled>
            <input id="data" type="text" name="" value="week or month number:<%=b%>  " disabled>
            <input id="data" type="text" name="" value="total prv_tax pay:<%=d%>  " disabled>
            <a id="Back" href="login.jsp">Back Home</a>

        </div>
        <br> <br> 
        <form action="report.jsp">
            <div class="report">
                <input id="data" type="submit" name="" value="GenerateReport">

            </div>
        </form>


    </body>
</div>
