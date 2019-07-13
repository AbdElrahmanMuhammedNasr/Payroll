
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title> Payroll</title>
    <link rel="stylesheet" href="css/style_2.css">
  </head>
  <body>


    <div class="login">
        <form action="mainservlet" method="POST">
          <input type="text" name="username" value="" placeholder="User Name">
          <input type="password" name="password" value="" placeholder="Password"><br><br>
          <hr>
          <input type="text" name="code" value="" placeholder="Code">
          <input type="text" name="salary" value="" placeholder="Salary">
          <input type="text" name="previous" value="" placeholder="Pervious Pay">
          <input type="text" name="number" value="" placeholder="Number">
          <input id="cl" type="submit" value="Calculate the Tax">
       </form>
         <a id="help" href="register.jsp">Create Account</a>
      </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/an.js"></script>

  </body>
</html>
