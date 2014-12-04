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
                KDA
            </th>
            <th>
                Items
            </th>
            </thead>
            <tbody>
            <c:forEach var="player" items="${match.radientPlayers}">
                <tr>
                    <c:set var="player" value="${player}"/>
                    <c:set var="radiantK" value="${radiantK+player.kda[0]}"/>
                    <c:set var="radiantD" value="${radiantK+player.kda[1]}"/>
                    <c:set var="radiantA" value="${radiantK+player.kda[2]}"/>
                    <jsp:include page="matchRow.jsp"/>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td><c:out value="${radiantK}"/>/<c:out value="${radiantD}"/>/<c:out value="${radiantA}"/></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
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
                KDA
            </th>
            <th>
                Items
            </th>
            </thead>
            <tbody>
            <c:forEach var="player" items="${match.direPlayers}">
                <tr>
                    <c:set var="player" scope="request" value="${player}"/>
                    <jsp:include page="matchRow.jsp"/>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
