<%-- any content can be specified here e.g.: --%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="jumbotron">
      <h1>${page.title}</h1>      
    </div>  
    <c:forEach items="${texts}"  var="t">
        <div class="panel panel-body">
            <span class="userStory">
                ${t.value}
            </span>
        </div>
    </c:forEach>
    
    <c:forEach items="${page.widgets}" var="w">
        <c:if test="${w.widgetId == 1}">
            <c:if test="${user != null}">
                <form action="/SpringCMS/WidgetSubmitUserStory" method="post">
                    <input type="hidden" name="pageId" value="${page.pageId}"/>
                    <input type="text" placeholder="Enter your comment here" name="userTxt" size="85%"/>
                    <input type="submit" class="btn btn-info" value="Submit User Story"/>
                </form>
            </c:if>
            <c:if test="${userStories != null}">
                <br>
                <h2>User Stories:</h2>
                <c:forEach items="${userStories}" var="story">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            ${story.user.name}
                            <c:if test="${story.user.userId == user.userId || user.isAdmin}">
                                    <a class="btn btn-danger pull-right marginBot" href="/SpringCMS/DeleteUserStory?id=${story.userStoryId}">Delete Story</a>
                            </c:if>
                        </div>
                        <div class="panel-body">
                            <span class="userStory">
                                ${story.storyText}
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </c:if>
    </c:forEach>
        
</div>