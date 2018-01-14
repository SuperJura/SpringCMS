<%-- 
    Document   : DisplayLink
    Created on : Jan 14, 2018, 10:02:03 PM
    Author     : JuraLocal
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>


<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="link" type="com.spring.models.Link"%>
<p>
    ${link.linkTitle}
</p>
<c:forEach items="${link.childLinks}" var="link">
    <jl:DisplayLink link="${link}"/>
</c:forEach>