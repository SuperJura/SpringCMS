<%-- 
    Document   : ChangeMain
    Created on : Jan 12, 2018, 12:27:05 PM
    Author     : JuraLocal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
        <jsp:include page="../partialJSP/Header.jsp"/>
        <c:if test="${page == null}">
            <a href="/SpringCMS/CreatePage?id=1" class="btn btn-info center-block">No main page! Click here to create one.</a>
        </c:if>
        <c:if test="${page != null}">
            <div class="container">
            <div class="jumbotron">
              <h1>${page.title}</h1>      
              <form action="/SpringCMS/ChangeTitle" method="post">
                  <span>
                      New title:
                  </span>
                  <input type="hidden" value="${page.pageId}" name="id"/>
                  <input type="text" name="title"/>
                  <input type="submit" value="Change title" class="btn btn-info"/>
              </form>
            </div>
            <p>This is some text.</p>      
            <p>This is another text.</p>      
          </div>
        </c:if>
        </body>
    </html>
</f:view>
