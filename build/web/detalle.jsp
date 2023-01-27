<%-- 
    Document   : detalle
    Created on : 08/12/2020, 11:31:37 AM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="en">
    <head>
        <jsp:include page="header.jsp" />
        <title>Detalle de la vacance - ${vac.nombre}</title>
    </head>

    <body>

        <div class="container">

            <jsp:include page="nav-simple.jsp" />
            
            <form method ="post" action="buscar" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
                </div>        
                <button type="submit" class="btn btn-success">Buscar</button>
            </form>
            
            <br><br><br>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">ID: ${vacante.id}</h3>
                </div>
                <div class="panel-body">
                    <h5><b>Vacante</b>:&nbsp;${vacante.nombre}</h5>
                    <h5><b>Publicado</b>: ${vacante.fechaPublicacion}</h5>                             
                    <b>Descripción:</b><br>
                    <p class="text-justify">${vacante.descripcion}</p>
                    <b>Detalles de la vacante</b>:<br>
                    <p>${vacante.detalle}</p><br>

                    <!--
                    Mostramos un boton para permitir a un usuario enviar su Curriculm Vitae para esta Vacante. Estamos mandando 
                    como parametro el id de esta vacante, ya que lo ocuparemos para hacer una busqueda para mostrar el nombre
                    de la vacante en el siguiente formulario que es el formulario para enviar los datos del usuario, junto con su
                    archivo DOC o PDF de su CV.
                    -->          
                    <p><a class="btn btn-default btn-success" title="Enviar Curriculm Vitae para aplicar a esta vacante." href="vacante?action=enviarCV&id=${vacante.id}" role="button">Enviar CV</a></p>
                </div>

            </div>      
            <jsp:include page="footer.jsp" />

        </div> <!-- /container -->

    </body>
</html>


