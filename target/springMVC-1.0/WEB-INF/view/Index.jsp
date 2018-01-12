<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS</title>
    </head>
    <body>

        <jsp:include page="partialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Welcome to CMS!"/>
        <h1>Hello World!</h1>
        <p>${var}</p>
    </body>
</html>
