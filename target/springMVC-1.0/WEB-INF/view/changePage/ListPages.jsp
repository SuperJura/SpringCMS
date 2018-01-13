<%-- 
    Document   : ListPages
    Created on : 13-Jan-2018, 15:48:48
    Author     : Jurica
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../partialJSP/Header.jsp"/>
        
        <a href="/SpringCMS/CreatePage" class="btn btn-info center-block"> Create new Page </a>
        <c:forEach items="${pages}" var="p">
            <div class="container topMargin">
                <div class="jumbotron">
                  <h1>${p.title}</h1>
                  <c:if test="${p.pageId != 1}">
                      <a href="/SpringCMS/PageDetails?pageId=${p.pageId}" class="btn btn-info"> Change page </a>
                      <a href="/SpringCMS/DeletePage?pageId=${p.pageId}" class="btn btn-danger"> Delete page </a>
                  </c:if>
                </div>  
          </div>
        </c:forEach>
    </body>
</html>
