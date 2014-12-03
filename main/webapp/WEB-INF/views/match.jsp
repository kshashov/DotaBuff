<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 24.11.2014
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">



    <div class="body">
      <div class="page-header">
        <h1>Матч #${match.id}</h1>
      </div>
      <jsp:include page="components/matchInfo.jsp"></jsp:include>
    </div>




  </tiles:putAttribute>
</tiles:insertDefinition>
