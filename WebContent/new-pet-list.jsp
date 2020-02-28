<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Pet List</title>
</head>
<body>
<form action = "createNewPetListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Owner Name: <input type = "text" name = "ownerName"><br />

Available Pets:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.type} |
${currentitem.item}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Pets">
</form>
<a href = "petIndex.html">Add new pets instead.</a>
</body>
</html>