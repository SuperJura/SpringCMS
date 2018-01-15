<%-- 
    Document   : DisplayLink
    Created on : Jan 15, 2018, 4:44:50 PM
    Author     : JuraLocal
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="displayLink" type="com.spring.models.Link"%>

<li>
    <c:if test="${displayLink.childLinks.size() > 0}">
        <li class="dropdown-submenu">
            <a class="test" tabindex="-1" href="#">${displayLink.linkTitle}<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <c:forEach items="${displayLink.childLinks}" var="l">
                    <jl:DisplayLink displayLink="${l}"/>
                </c:forEach>
            </ul>
        </li>
    </c:if>
    <c:if test="${displayLink.childLinks.size() == 0 && displayLink.desPageId != -1}">
        <a tabindex="-1" href="/SpringCMS/ViewPage?pageId=${displayLink.desPageId}">${displayLink.linkTitle}</a>
    </c:if>
 
</li>

<!--
<li><a tabindex="-1" href="#">HTML</a></li>
<li><a tabindex="-1" href="#">CSS</a></li>
<li class="dropdown-submenu">
  <a class="test" tabindex="-1" href="#">New dropdown <span class="caret"></span></a>
  <ul class="dropdown-menu">
    <li><a tabindex="-1" href="#">2nd level dropdown</a></li>
    <li><a tabindex="-1" href="#">2nd level dropdown</a></li>
    <li class="dropdown-submenu">
      <a class="test" href="#">Another dropdown <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">3rd level dropdown</a></li>
        <li><a href="#">3rd level dropdown</a></li>
      </ul>
    </li>
  </ul>
</li>

-->