<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title></title>
</head>
<body>
    <div align="center">
        <h1>ADD BOOK</h1>
        <form action="save" method="POST" modelAttribute="book">
        <table>
                <tr>
                <td>ID:</td>
                <td><input type = "text" name="id" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type = "text" name="name" /></td>
            </tr>


            <tr>
                <td>Author:</td>
                <td><input type = "text" name="author" /></td>
            </tr>
            
            <tr>
                <td>Cost:</td>
                <td><input type = "text" name="cost" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>