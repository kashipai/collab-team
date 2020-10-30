<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>
</head>
<body>
<div align="center">
    <h1>Add Customer</h1>
    <form action="save" method="POST" modelAttribute="customer">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type = "text" name="id" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><input type = "text" name="firstname" /></td>
            </tr>


            <tr>
                <td>Last Name:</td>
                <td><input type = "text" name="lastname" /></td>
            </tr>

            <tr>
                <td>Email ID:</td>
                <td><input type = "text" name="email" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
