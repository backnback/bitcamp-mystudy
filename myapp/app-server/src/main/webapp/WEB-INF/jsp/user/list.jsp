<%@ page
    language="java" 
    contentType="text/html;charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>

<h1>회원 목록</h1>
<p><a href='form'>새 회원</a></p>
<table>
  <thead>
      <tr><th>번호</th><th>이름</th><th>이메일</th></tr>
  </thead>
  <tbody>

<c:forEach items="${list}" var="user">
<tr>
  <td>${user.no}</td>
  <td>
    <img src="https://d07owler4941.edge.naverncp.com/NFZ2WwiwDV/user/${user.photo == null ? 'default.png' : user.photo}?type=f&w=20&h=20">
    <a href='view?no=${user.no}'>${user.name}</a></td>
  <td>${user.email}</td>
</tr>
</c:forEach>

  </tbody>
</table>


</body>
</html>