<%-- 
    Document   : ChangeLink
    Created on : Jan 14, 2018, 10:02:03 PM
    Author     : JuraLocal
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>


<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="link" type="com.spring.models.Link"%>

<a href="#${link.linkId}" class="list-group-item" data-toggle="collapse">
    <i class="glyphicon glyphicon-chevron-right"></i>
    <span class="text-info">
        ${link.linkTitle}
    </span>
</a>
<div class="list-group collapse" id="${link.linkId}">
    <a href="/SpringCMS/ChangeLink?linkId=${link.linkId}"class="list-group-item">Change Link: ${link.linkTitle}</a>
    <c:forEach items="${link.childLinks}" var="link">
        <jl:ChangeLink link="${link}"/>
    </c:forEach>
</div>