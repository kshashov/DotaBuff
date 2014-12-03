<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 02.12.2014
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<td style="width:90px">
    <img data-src="holder.js/59x33" class="img-thumbnail" alt="hero"
         src="http://cdn.dota2.com/apps/dota2/images/heroes/${player.hero}_sb.png"
         data-holder-rendered="true">
</td>
<td>
    <c:choose>
        <c:when test="${player.personaName == ''}">
            Аноним
        </c:when>
        <c:otherwise>
            <a href="../players/${player.id}"><c:out
                    value="${player.personaName}"/></a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${player.leaverStatus != ''}">
            <br/><c:out value="${player.leaverStatus}"/>
        </c:when>
    </c:choose>
</td>
<td>
    <c:out value="${player.kda[0]}"/> / <c:out value="${player.kda[1]}"/> /
    <c:out value="${player.kda[2]}"/>
</td>
<td>
    <c:forEach var="item" items="${player.items}">
        <img src = "../resources/items/${item.name}_lg.png" style="height:40px"/>
    </c:forEach>
</td>
