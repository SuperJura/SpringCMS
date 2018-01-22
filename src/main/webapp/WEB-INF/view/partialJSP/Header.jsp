<script src="/SpringCMS/resources/js/jquery-2.2.3.js" type="text/javascript"></script>
<script src="/SpringCMS/resources/js/Popper.js" type="text/javascript"></script>
<script src="/SpringCMS/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/SpringCMS/resources/js/javascript.js" type="text/javascript"></script>
<link href="/SpringCMS/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/SpringCMS/Home" class="btn btn-info topMargin">Home Page</a>
        </div>
        <div class="nav navbar-nav">
            <div class="dropdown topMargin leftMargin">
                    <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">
                        Links
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${links}" var="l">
                           <jl:DisplayLink displayLink="${l}"/>
                        </c:forEach>
                    </ul>
                </div>
        </div>
        <c:if test="${user == null}">
            <div class="center-block pull-right">
                <form action="/SpringCMS/Login" method="post" class="topMargin">
                    <span class="text-primary"> Username: </span>
                    <input type="text" name="name"/>
                    <span class="text-primary"> Password: </span>
                    <input type="text" name="pass"/>
                    <input type="submit" class="btn btn-info" value="Login" name="login"/>
                    <input type="submit" class="btn btn-success" value="Register" name="register"/>
                </form>
            </div>
            
        </c:if>
        <c:if test="${user != null}">
            <div class="center-block pull-right topMargin">
                <a class="btn btn-info" href="/SpringCMS/Logout">Logout</a>
            </div>
        </c:if>
        <c:if test="${user.isAdmin == true}">
            <div id="navbar" class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="/SpringCMS/Admin/PageDetails?pageId=1">Change main page</a></li>
                    <li><a href="/SpringCMS/Admin/ListPages">Change pages</a></li>
                    <li><a href="/SpringCMS/Admin/ChangeLinks">Change Links</a></li>
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

.floatRight{
    float: right;
    text-align: right;
}

.inline{
    display: inline;
}

.just-padding {
    padding: 15px;
}

.list-group.list-group-root {
    padding: 0;
    overflow: hidden;
}

.list-group.list-group-root .list-group {
    margin-bottom: 0;
}

.list-group.list-group-root .list-group-item {
    border-radius: 0;
    border-width: 1px 0 0 0;
}

.list-group.list-group-root > .list-group-item:first-child {
    border-top-width: 0;
}

.list-group.list-group-root > .list-group > .list-group-item {
    padding-left: 30px;
}

.list-group.list-group-root > .list-group > .list-group > .list-group-item {
    padding-left: 45px;
}

.list-group-item .glyphicon {
    margin-right: 5px;
}

.textRigth{
    text-align: right;
}

.dropdown-submenu {
    position: relative;
}

.dropdown-submenu .dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -1px;
}

.userStory{
    width:150px;
    word-wrap:break-word;
}

</style>

<script>
    $(function() {
      $('.list-group-item').on('click', function() {
        $('.glyphicon', this)
          .toggleClass('glyphicon-chevron-right')
          .toggleClass('glyphicon-chevron-down');
      });

    });
    
    $(document).ready(function(){
      $('.dropdown-submenu a.test').on("click", function(e){
        $(this).next('ul').toggle();
        e.stopPropagation();
        e.preventDefault();
      });
    });
</script>