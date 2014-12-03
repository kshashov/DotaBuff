<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
  Menu
  <ul>
    <li>
      <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
      <a href="${homeUrl}">Home</a>
    </li>
    <li>
      <spring:url value="/players" var="players" htmlEscape="true"/>
      <a href="${players}">Players</a>
    </li>
    <li>
      <spring:url value="/about" var="aboutUrl" htmlEscape="true"/>
      <a href="${aboutUrl}">About</a>
    </li>
  </ul>
</div>
