<%-- 
    Document   : DisplayHeader
    Created on : Jan 14, 2018, 4:43:56 PM
    Author     : JuraLocal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>


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
            <c:forEach items="${links}" var="link">
                <jl:DisplayLink link="${link}"/>
            </c:forEach>
        </body>
    </html>
</f:view>
