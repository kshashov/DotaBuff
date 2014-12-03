<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">



    <div class="body">
      <div class="page-header">
        <h1>${player.personaName}</h1>
      </div>
      <div class = "panel panel-primary">
        <div class = "panel-heading">
          <h3 class = "panel-title">Последние матчи</h3>
        </div>
        <div class = "panel-body">
          <jsp:include page="components/smallMatchInfo.jsp"></jsp:include>
        </div>
      </div>
    </div>




  </tiles:putAttribute>
</tiles:insertDefinition>
