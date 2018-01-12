<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/Home" class="navbar-text navbar-left">Home page</a>
        </div>
        <c:if test="${user == null}">
            <form action="/Login" method="post">
                <span> Username: </span>
                <input type="text" name="name"/>
                <span> Password: </span>
                <input type="text" name="pass"/>
                <input type="submit" value="Login"/>
            </form>
        </c:if>
        <c:if test="${korisnik.administrator == true}">
            <div id="navbar" class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="/WebShop/PristupStranicama">Pregled pristupa stranicama</a></li>
                    <li><a href="/WebShop/PregledSpajanja">Pregled spajanja</a></li>
                    <li><a href="/WebShop/PregledKupnji">Pregled kupnja</a></li>
                    <li><a href="/WebShop/Kategorije?akcija=1">Promjena proizvoda</a></li>
                    <li>
                        <a href="/WebShop/Profil">
                            Košarica <span class="bold"> ${korisnik.korisnickoIme}</span>
                        </a>
                    </li>
                </ul>
            </div>
        </c:if>
    </div>
</nav>