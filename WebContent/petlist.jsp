<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A List of Pets</title>
</head>
<body>
<form method="post" action="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allPets}" var="thispet">
			<tr>
				<td><input type="radio" name="id" value="${thispet.id}"></td>
					<td>${thispet.name}</td>
					<td>${thispet.type}</td>
					<td>${thispet.owner}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToPetLog"> 
		<input type="submit" value="delete" name="doThisToPetLog"> 
		<input type="submit" value="add" name="doThisToPetLog">
	</form>
</body>
</html>