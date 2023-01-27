<%-- 
    Document   : acerca
    Created on : 12/12/2020, 12:26:14 PM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="en">
    <head>
        <jsp:include page="header.jsp" />
        <title>My Company - Acerca</title>

    </head>

    <body>

        <div class="container">
            <jsp:include page="nav-simple.jsp" />
            <!-- Jumbotron -->
            <div class="jumbotron">
                <h2>ACERCA</h2>
                <p class="lead text-justify">Comparte este proyecto :D <a href='https://www.udemy.com/java-servlets-jsp' target="_blank">Java Servlets y JSP - Desarrollo web con Java EE</a>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem 
                    Ipsum has been the industry's 
                    standard dummy text ever since the 1500s, 
                    when an unknown<br> <br>         
                    <b>Autor</b>: bryam rubio valverde<br>
                    <b>Email</b>: bryamrubio312@gmail.com
                <p>
            </div>
            <jsp:include page="footer.jsp" />
        </div> <!-- /container -->

    </body>
</html>

