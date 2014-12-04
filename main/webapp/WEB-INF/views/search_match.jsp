<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 24.11.2014
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">



    <div class="body">
      <div class="page-header">
        <h1>Поиск матча</h1>
      </div>
      <div align="center">
        <form:form method="POST" modelAttribute="match" class="navbar-form navbar-center">
          <div class="form-group" style = "display: inline-block">
            <form:input path="id" required="required" class="form-control" placeholder="ID"/>
          </div>
          <button type="submit" class="btn btn-default">OK</button>
        </form:form>
      </div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>
