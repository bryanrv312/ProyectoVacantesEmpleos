<%-- 
    Document   : nav-admin
    Created on : 25/11/2020, 10:59:26 PM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->
            <div class="masthead">
                <h3 class="text-muted">My Company - Administración</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="admin?action=crear">Crear Vacante</a></li>            
                        <li><a href="vacante?action=lista">Vacantes</a></li>
                        <li><a href="solicitud?action=solicitudes">Solicitudes</a></li>
                        <li><a href="admin?action=logout">Salir</a></li>                     
                    </ul>
                </nav>
            </div>
</html>
