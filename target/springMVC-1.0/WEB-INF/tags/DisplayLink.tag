<%-- 
    Document   : DisplayLink
    Created on : Jan 15, 2018, 4:44:50 PM
    Author     : JuraLocal
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="link" type="com.spring.models.Link"%>

<li>
    <a href="#${link.linkId}" class="list-group-item" data-toggle="collapse">
        <i class="glyphicon glyphicon-chevron-right"></i>
        <span class="text-info">
            ${link.linkTitle}
        </span>
    </a>
    <c:if test="${link.childLinks.size() > 0}">
        <li class="dropdown-submenu">
            <ul class="dropdown-menu" id="${link.linkId}">
                <a href="/SpringCMS/ChangeLink?linkId=${link.linkId}"class="list-group-item">${link.linkTitle}<span class="caret"></span></a>
                <c:forEach items="${link.childLinks}" var="link">
                    <jl:DisplayLink link="${link}"/>
                </c:forEach>
            </ul>
        </li>
    </c:if>
</li>