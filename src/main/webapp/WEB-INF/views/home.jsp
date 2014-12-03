<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">



    <div class="body">
      <h1>Home page !</h1>

      <p>The time on the server is ${serverTime}.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
        magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</P>
    </div>



  </tiles:putAttribute>
</tiles:insertDefinition>
