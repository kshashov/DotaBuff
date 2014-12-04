<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 23.11.2014
  Time: 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="center-block" style = "text-align: center">
    <h1>
        <c:choose>
            <c:when test="${match.radiantWin}">
                <span class="label label-success">RADIANT VICTORY</span>
            </c:when>
            <c:otherwise>
                <span class="label label-danger">DIRE VICTORY</span>
            </c:otherwise>
        </c:choose>
    </h1>
</div>
<table class="table">
    <thead>
    <th>
        Время начала
    </th>
    <th>
        Тип лобби
    </th>
    <th>
        Режим
    </th>
    <th>
        Длительность
    </th>
    </thead>
    <tr>
        <td>
            <fmt:timeZone value="UTC">
                <fmt:formatDate value="${match.startTime}" type="both"
                                pattern="yyyy-MM-dd HH:mm:ss" var="time"/>
            </fmt:timeZone>
            <time datetime='${time}Z' data-format="HH:mm D.MM.YYYY"></time>
        </td>
        <td>
            <c:out value="${match.lobbieType}"/>
        </td>
        <td>
            <c:out value="${match.gameMode}"/>
        </td>
        <td>
            <fmt:timeZone value="UTC">
                <fmt:formatDate value="${match.duration}" type="time"/>
            </fmt:timeZone>
        </td>
    </tr>
</table>
<c:set var="radiantK" value="${0}"/>
<c:set var="radiantD" value="${0}"/>
<c:set var="radiantA" value="${0}"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Свет</h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-hover">
            <thead>
            <th>
                Герой
            </th>
            <th>
                Игрок
            </th>
            <th>
                K
            </th>
            <th>
                D
            </th>
            <th>
                A
            </th>
            <th>
                Items
            </th>
            </thead>
            <tbody>
            <c:forEach var="player" items="${match.radiantPlayers}">
                <tr>
                    <c:set var="player" value="${player}" scope="request"/>
                    <c:set var="radiantK" value="${radiantK+player.kda[0]}"/>
                    <c:set var="radiantD" value="${radiantD+player.kda[1]}"/>
                    <c:set var="radiantA" value="${radiantA+player.kda[2]}"/>
                    <jsp:include page="matchRow.jsp"/>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td><c:out value="${radiantK}"/></td>
                <td><c:out value="${radiantD}"/></td>
                <td><c:out value="${radiantA}"/></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<c:set var="direK" value="${0}"/>
<c:set var="direD" value="${0}"/>
<c:set var="direA" value="${0}"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Тьма</h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-hover">
            <thead>
            <th>
                Герой
            </th>
            <th>
                Игрок
            </th>
            <th>
                K
            </th>
            <th>
                D
            </th>
            <th>
                A
            </th>
            <th>
                Items
            </th>
            </thead>
            <tbody>
            <c:forEach var="player" items="${match.direPlayers}">
                <tr>
                    <c:set var="player" scope="request" value="${player}"/>
                    <c:set var="direK" value="${direK+player.kda[0]}"/>
                    <c:set var="direD" value="${direD+player.kda[1]}"/>
                    <c:set var="direA" value="${direA+player.kda[2]}"/>
                    <jsp:include page="matchRow.jsp"/>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td><c:out value="${direK}"/></td>
                <td><c:out value="${direD}"/></td>
                <td><c:out value="${direA}"/></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
