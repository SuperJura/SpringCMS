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
            <title>Change Links</title>
        </head>
        <body>
            <jsp:include page="../partialJSP/Header.jsp"/>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="col-xs-4">
                            <a href="/SpringCMS/Admin/AddNewLink?parentLinkId=-1" class="btn btn-info center-block">
                                Add new base Link
                            </a>
                                <div class="list-group list-group-root well">
                                    <c:forEach items="${links}" var="link">
                                        <jl:ChangeLink link="${link}"/>
                                    </c:forEach>
                                </div>
                          
                        </div>
                        <div class="col-md-8">
                            <c:if test="${changeLink != null}">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        ${changeLink.linkTitle} &nbsp;
                                        <form action="/SpringCMS/Admin/ChangeLinkTitle" class="inline">
                                            <input type="hidden" name="linkId" value="${changeLink.linkId}" />
                                            <input type="text" name="linkTitle" />
                                            <input type="submit" value="Change title" class="btn btn-info"/>
                                        </form>
                                    </div>
                                    <div class="panel-body topMargin">
                                            <c:if test="${changeLink.childLinks.size() > 0}">
                                                <p class="bg-danger">
                                                    This link cant have redirect to page because it has child links!
                                                </p>
                                            </c:if>
                                            <c:if test="${changeLink.childLinks.size() == 0}">
                                                <span class="bg-info">
                                                    This link will go to page:
                                                </span>
                                                <div class="dropdown">
                                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        Pages
                                                    </button>
                                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                        <c:forEach items="${pages}" var="p">
                                                            <li>
                                                                <a class="dropdown-item" href="/SpringCMS/Admin/ChangeLinkPage?linkId=${changeLink.linkId}&pageId=${p.pageId}">
                                                                    <c:if test="${p.pageId == changeLink.desPageId}">
                                                                        <b>Current: </b>
                                                                    </c:if>
                                                                    ${p.title}
                                                                </a>
                                                            </li>
                                                        </c:forEach>
                                                        <li class="divider"></li>
                                                        <li>
                                                            <a class="dropdown-item" href="/SpringCMS/Admin/ChangeLinkPage?linkId=${changeLink.linkId}&pageId=-1">
                                                                <c:if test="${changeLink.desPageId == -1}">
                                                                    <b>Current: </b>
                                                                </c:if>
                                                                No Page
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </c:if>
                                    </div>
                                    <div class="panel-footer">
                                        <a href="/SpringCMS/Admin/AddNewLink?parentLinkId=${changeLink.linkId}" class="btn btn-info topMargin"> Add new sublink to this link </a>

                                        <a href="/SpringCMS/Admin/DeleteLink?linkId=${changeLink.linkId}" class="btn btn-danger topMargin">
                                            Delete this link
                                        </a>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </html>
</f:view>
