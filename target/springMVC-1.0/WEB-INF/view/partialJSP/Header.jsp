<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!--<script src="../resources/js/jquery-2.2.3.js" type="text/javascript"></script>
<link href="../resources/Css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="../resources/js/javascript.js" type="text/javascript"></script>
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/SpringCMS/Home" class="navbar-text navbar-left">Home page</a>
        </div>
        <c:if test="${user == null}">\
            <div class="center-block pull-right">
                <form action="/SpringCMS/Login" method="post" class="topMargin">
                <span class="text-primary"> Username: </span>
                <input type="text" name="name"/>
                <span class="text-primary"> Password: </span>
                <input type="text" name="pass"/>
                <input type="submit" class="btn btn-info" value="Login"/>
            </form>
            </div>
            
        </c:if>
        <c:if test="${user != null}">
            <div class="center-block pull-right">
                <a class="btn btn-info" href="/SpringCMS/Logout">Logout</a>
            </div>
        </c:if>
        <c:if test="${user.isAdmin == true}">
            <div id="navbar" class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="/SpringCMS/ChangeMain">Change main page</a></li>
                    <li><a href="/SpringCMS/ChangePages">Change pages</a></li>
                    <li><a href="/SpringCMS/ChangeLinks">Change links</a></li>
                    <li><a href="/SpringCMS/ChangeHeader">Change header</a></li>
                </ul>
            </div>
        </c:if>
    </div>
</nav>

<style>
    body {
    padding-top: 55px;
}

.txtBlue{
    color: blue;
}

.background-dark{
    background-color: rgba(00,10,59, 0.1) !important; 
}

.background-light{
    background-color: rgba(00,15,75, 0.1) !important; 
}

.txtLarge{
    font-size: xx-large !important;
}

.hoverChange :hover{
    background-color: #269abc !important; 
    color: white !important;
}

.bold{
    font-weight: bold;
    color: white;
    text-decoration: underline;
}

.boldBlack{
    font-weight: bold;
    color: black;
    text-decoration: underline;
}

.leftMargin{
    margin-left: 15px;
}

.topMargin{
    margin-top: 5px;
}

</style>