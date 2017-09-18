<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Shopping Cart Contents</TITLE>
</HEAD>
<BODY>
  <%@ include file="/jsp/header.jsp" %>
  Your shopping cart contains:
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

      <c:forEach items="${cart}" var="item">
      <tr>
        <td>${item.id}</td>
        <td>${item.title}</td>
        <td>${item.artist}</td>
        <td>${item.releaseDateString}</td>
        <td>$${item.listPrice}</td>
        <td><b><font color='green'>$${item.price}</font></b></td>
      </tr>
      </c:forEach>

    </tbody>
  </table>
</BODY>
</HTML>
