<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<body>
<div class="container">
    <h1>アカウント管理</h1>
<table border ="1">
  <tr>
    <th>ID</th>
    <th>ユーザー名</th>
    <th>組織名</th>
    <th>Role</th>
  </tr>
<c:forEach var="record" items="${records}">

  <tr>
    <td><c:out value="${record.custid}"/></td>
    <td><c:out value="${record.username}"/></td>
    <td><c:out value="${record.orgname}"/></td>
    <td><c:out value="${record.role}"/></td>
  </tr>

</c:forEach>
</table>


</div>
</body>
</html>
