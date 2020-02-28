<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet Lists</title>
</head>
<body>
<form method = "post" action = "">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name ="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan="5">Owner: ${currentlist.owner.ownerName}</td></tr>
	<c:forEach var = "listVal" items = "${currentlist.listOfPets}">
 	<tr><td></td><td colspan="3">
 	${listVal.name}, ${listVal.type}
 	</td>
 	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addPetsToOwnerServlet">Create a New Pet List</a>
<a href="petIndex.html">Insert a new pet</a>
</body>
</html>