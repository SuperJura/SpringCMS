<%-- 
    Document   : ChangeMain
    Created on : Jan 12, 2018, 12:27:05 PM
    Author     : JuraLocal
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Change page</title>
        </head>
        <body>
            <jsp:include page="../partialJSP/Header.jsp"/>
            <c:if test="${page == null}">
                <a href="/SpringCMS/Admin/CreatePage?id=1" class="btn btn-info center-block">No main page! Click here to create one.</a>
            </c:if>
            <c:if test="${page != null}">
                <div class="container">
                    <div class="jumbotron">
                      <h1>${page.title}</h1>      
                      <form action="/SpringCMS/Admin/ChangeTitle" method="post">
                        <span>
                            New title:
                        </span>
                        <input type="hidden" value="${page.pageId}" name="id"/>
                        <input type="text" name="title"/>
                        <input type="submit" value="Change title" class="btn btn-info"/>
                        
                        <c:if test="${page.pageId != 1}">
                            <div class="container floatRight">
                              <div class="row">
                                  <div class="col-lg-12">
                                      <div class="button-group">
                                         <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span> <span class="caret"></span></button>
                                           <ul class="dropdown-menu">
                                              <li><b>Used widgets</b></li>
                                              <c:forEach items="${page.widgets}" var="w">
                                                  <li><a href="/SpringCMS/Admin/RemoveWidget?pageId=${page.pageId}&widgetId=${w.widgetId}" class="small" data-value="option1" tabIndex="-1"><input type="checkbox" checked="true"/>&nbsp;${w.widgetName}</a></li>
                                              </c:forEach>
                                              <li><b>Unused widgets</b></li>
                                              <c:forEach items="${widgets}" var="w">
                                                  <li><a href="/SpringCMS/Admin/AddWidget?pageId=${page.pageId}&widgetId=${w.widgetId}" class="small" data-value="option1" tabIndex="-1"><input type="checkbox"/>&nbsp;${w.widgetName}</a></li>
                                              </c:forEach>
                                           </ul>
                                       </div>
                                  </div>
                              </div>
                            </div>
                        </c:if>
                      </form>
                    </div>  
                    <jl:ChangePageText newText="true"/>
                    <c:forEach items="${texts}"  var="t">
                        <jl:ChangePageText textId="${t.textId}" textValue="${t.value}"/>
                    </c:forEach>
              </div>
            </c:if>
        </body>
    </html>
</f:view>
