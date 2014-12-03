<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-striped table-hover">
    <thead>
    <th colspan="2">
        Герой
    </th>
    <th>
        Результат
    </th>
    <th>
        Тип
    </th>
    <th>
        Длительность
    </th>
    <th>
        KDA
    </th>
    </thead>
    <c:forEach var="match" items="${matches}">
        <tr>
            <c:set var="match" scope="request" value="${match}" />
            <jsp:include page="smallMatchRow.jsp"/>
        </tr>
    </c:forEach>
</table>
