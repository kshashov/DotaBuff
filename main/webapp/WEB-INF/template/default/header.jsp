<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 22.11.2014
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<div class="header">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">DotaBuff</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${urls['home']}">Home</a></li>
                    <li><a href="${urls['players']}">Players</a></li>
                    <li><a href="${urls['matches']}">Matches</a></li>
                </ul>
                <!--<ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="../../">Ноme</a></li>
                </ul>-->
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>

</div>
