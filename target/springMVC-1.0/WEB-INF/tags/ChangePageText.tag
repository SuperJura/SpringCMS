<%-- 
    Document   : ChangePageText
    Created on : 13-Jan-2018, 13:56:46
    Author     : Jurica
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>

<%@attribute name="textId" required="false"%>
<%@attribute name="textValue" required="false"%>

<%@attribute name="newText" required="false"%>

<%-- any content can be specified here e.g.: --%>
<div class="topMargin">      
    <c:if test="${newText != null}">
        <form action="/SpringCMS/Admin/AddText" method="post">
            <input type="hidden" name="pageId" value="${page.pageId}"/>
            <input type="text" name="value" value="" width="300px"/>
            <input type="submit" value="Add new Text" class="btn btn-success"/>
        </form>
    </c:if>
    <c:if test="${textValue != null}">
        <form action="/SpringCMS/Admin/ChangeText" method="post">
            <input type="hidden" name="textId" value="${textId}"/>
            <input type="text" name="value" value="${textValue}" size="100"/>
            <input type="submit" value="Change Text" class="btn btn-info"/>
            <a href="/SpringCMS/Admin/DeleteText?textId=${textId}" class="btn btn-danger">Delete Text</a>
        </form>
    </c:if>
</div>
