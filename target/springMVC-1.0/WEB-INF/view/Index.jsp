
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS</title>
    </head>
    <body>

        <jsp:include page="partialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Welcome to CMS!"/>
        <c:if test="${page != null}">
            <jl:DisplayPage/>
        </c:if>
        <c:if test="${page == null}">
            <h2 class="center-block">
                Welcome to CMS site.
            </h2>
        </c:if>
    </body>
</html>
