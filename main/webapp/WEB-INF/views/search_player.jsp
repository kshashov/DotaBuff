<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">


        <div class="body">
            <div class="page-header">
                <h1>Поиск игрока</h1>
            </div>
            <div align="center">
                <form:form method="POST" modelAttribute="player" class="navbar-form navbar-center">
                    <div class="form-group" style="display: inline-block">
                        <form:input path="id" required="required" class="form-control" placeholder="ID"/>
                    </div>
                    <button type="submit" class="btn btn-default">OK</button>
                </form:form>
                    <small>
                        <p>URL: http://steamcommunity.com/profiles/76561198039967187/</p>

                        <p>SteamID32 (DotaID): 79701459</p>

                        <p>SteamID64 (Steam community): 76561198039967187</p>
                    </small>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

