<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp" flush="false"></jsp:include>
Result for keyword : <%= request.getParameter("keyword") %>
<br>
size = ${size} 
<br>
<table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>List Price</th>
        <th><font color='green'>Your Price</font></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${results}" var="item">
      <tr>
        <td>${item.id}</td>
        <!--  Optional use of c:out -->
        <td><c:out value="${item.title}"/></td>
        <td>${item.artist}</td>
        <td>${item.releaseDateString}</td>
        <td>$${item.listPrice}</td>
        <td><b><font color='green'>${item.price}</font></b></td>
        <td><a href='<c:url value="/cart"><c:param name="itemID" value="${item.id}"/></c:url>'>Add to cart</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>