<%-- 
    Document   : headerMessage
    Created on : Jun 7, 2016, 11:05:26 AM
    Author     : Jurica
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="defaultMessage" required="true"%>
<%@attribute name="highlited" required="false"%>

<%-- any content can be specified here e.g.: --%>
<div class="alert alert-info text-center">
    <c:if test="${empty headerMsg}">
        ${defaultMessage}
    </c:if>
    <c:if test="${not empty headerMsg}">
        ${headerMsg}
        <c:remove var="headerMsg" scope="session" />
    </c:if>
    <span class="txtBlue">
        ${highlited}
    </span>

</div>