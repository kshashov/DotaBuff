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
<td>
    <img data-src="holder.js/59x33" class="img-thumbnail" alt="hero"
         src="http://cdn.dota2.com/apps/dota2/images/heroes/${match.userInMatch.hero}_sb.png"
         data-holder-rendered="true">
</td>
<td>
    <c:out value="${match.userInMatch.locHero}"/>
</td>
<td>
    <a href="../matches/${match.id}">
        <div>
            <c:choose>
                <c:when test="${match.userInMatch.leaverStatus != ''}">
                    <p><span class="label label-danger"><c:out value="${match.userInMatch.leaverStatus}"/></span></p>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${match.userInMatch.win == true}">
                            <p><span class="label label-success">Победа</span></p>
                        </c:when>
                        <c:otherwise>
                            <p><span class="label label-danger">Поражение</span></p>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>

           <fmt:timeZone value="UTC">
                <fmt:formatDate value="${match.startTime}" type="both"
                                pattern="yyyy-MM-dd HH:mm:ss" var = "time"/>
            </fmt:timeZone>
            <time datetime = '${time}Z'  data-format="HH:mm D.MM.YYYY"></time>
        </div>
    </a>
</td>
<td>
    <c:out value="${match.gameMode}"/><br>
    <c:out value="${match.lobbieType}"/>
</td>
<td>
    <fmt:timeZone value="UTC">
        <fmt:formatDate value="${match.duration}" type="time"/>
    </fmt:timeZone>
    <!-- <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" style="width: 60%"><span class="sr-only">60% Complete</span></div>-->
</td>
<td>
    <c:out value="${match.userInMatch.kda[0]}"/> / <c:out value="${match.userInMatch.kda[1]}"/> / <c:out
        value="${match.userInMatch.kda[2]}"/>
</td>
