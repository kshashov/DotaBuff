<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DotaBuff</title>
    <link href="${urls['bootstrap.min.css']}" rel="stylesheet"/>
    <style type="text/css">
        table td {
            vertical-align: middle !important;
        }

        a {
            text-decoration: none !important;
            color: inherit !important;
        }

        body {
            margin: 0px;
            padding: 0px;
            height: 100%;
            overflow: hidden;
        }

        .page {
            min-height: 100%;
            position: relative;
            max-width: 1000px;
            margin: 0 auto;
        }

        .header {
            padding: 10px;
            width: 100%;
            text-align: center;
        }

        .content {
            padding: 10px;
            padding-bottom: 20px; /* Height of the footer element */
            overflow: hidden;
        }

        /*.menu {
          padding:50px 10px 0px 10px;
          width:200px;
          float:left;
        }

        .body {
          margin:50px 10px 0px 250px;
        }*/

        .footer {
            clear: both;
            position: absolute;
            bottom: 0;
            left: 0;
            text-align: center;
            width: 100%;
            height: 20px;
        }

    </style>
</head>
<body>
<div class="page">
    <tiles:insertAttribute name="header"/>
    <div class="content">
       
        <tiles:insertAttribute name="body"/>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>
<script src="${urls['jquery']}"></script>
<script src="${urls['bootstrap.min.js']}"></script>
<script src="${urls['moment.js']}"></script>
<script>
    $(function () {
        $("time[data-format]").each(function () {
            var el = $(this);
            var dt = moment(el.attr("datetime"));
            el.text(dt.format(el.data("format")));
        });
    })
</script>

</body>
</html>
