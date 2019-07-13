<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title> Payroll</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <div class="register" >
        <form action="mainservlet" method="GET">
            <input type="text" name="nat" placeholder="Nationality">
            <input type="text" name="com" placeholder="Company Name">
            <input type="text" name="jo"  placeholder="Job">
            <input type="text" name="co"  placeholder="Code">
            <input type="text" name="sa"  placeholder="Salary">
            <input type="text" name="un"  placeholder="User Name">
            <input type="password" name="pa"  placeholder="Password">

            <select id="MonthOr" name="MonthOr">
                <option value="month" > month</option>
                <option value="week"> week</option>
            </select>
            <input id="but2" type="submit"  value="Sign up">
              <a id="but" href="login.jsp">Click To Calculate Tax</a>

          </form>

    </div>
</body>
</div>
