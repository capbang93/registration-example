<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
 <h1>Employee Register Form</h1>
 <form action="<%= request.getContextPath() %>/register" method ="post">
 <table style="with:80%">
 <tr>
 <td> Firt Name</td>
 <td><input type = "text" name = "firstName" /></td>
 </tr>
 <tr>
 <td> Last Name </td>
 <td><input type = "text" name = "lastName" /></td>
 </tr>
 <tr>
 <td> 한글 이름 </td>
 <td><input type = "text" name = "username" /></td>
 </tr> 
 <tr>
 <td> Password </td>
 <td><input type = "password" name = "password" /></td>
 </tr> 
 <tr>
 <td> Address </td>
 <td><input type = "text" name = "address" /></td>
 </tr> 
 <tr>
 <td> Contact No </td>
 <td><input type = "text" name = "contact" /></td>
 </tr> 
 </table>
 <input type="submit" value="Submit" />
 </form>
 </div>
</body>
</html>