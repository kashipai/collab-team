<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Edit book</title>
</head>
<meta charset="ISO-8859-1">
 <div align="center">
        <h1>EDIT BOOKS</h1>
        <form action="edit" method="PUT" modelAttribute="book">
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