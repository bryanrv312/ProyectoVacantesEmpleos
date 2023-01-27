
<%--@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="header.jsp" /> 
        <title>Departamento de Recursos Humanos - My Company</title>
    </head>

    <body>

        <div class="container">

            <jsp:include page="nav-simple.jsp" />  

            
            
            <!-- Formulario para la busqueda. El formulario es enviado por POST al BusquedaController -->    
            <form method ="post" action="buscar" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
                </div>        
                <button type="submit" class="btn btn-success">Buscar</button>
            </form>

            
            
            <!-- Jumbotron -->
            <div class="jumbotron">
                <h2>¡ENCUENTRA TU TRABAJO IDEAL!</h2>
                <!--
                <h4>ESTAMOS CONTRATANDO</h4>
                -->
                <p class="lead text-justify">Bienvenido a My Company, aquí podrás encontrar ofertas de empleos 
                    que sean adecuados a tu perfil, experiencia y ubicación. 
                    Es muy fácil de usar, solo haz clic en una vacante, ingresa para ver los detalles y envíanos tu CV en formato 
                    PDF, DOC o DOCX. Nosotros revisaremos tu CV y posteriormente te contactaremos.<br><br>

                <p><a class="btn btn-lg btn-success" href="vacante?action=lista" role="button">Ver más Ofertas</a></p>                
            </div>

            <h1>Ofertas recientes</h1>

            <!-- Example row of columns -->
            <div class="row">
                
                <c:forEach items="${ultimas}" var="vac" varStatus="status">
                    <div class="col-lg-4">
                        <h2>${vac.id}</h2>
                        <p class="text-danger" >${vac.nombre}</p>
                        <p class="text-justify" >${vac.descripcion}</p>
                        <p><a class="btn btn-primary" href="vacante?action=ver&id=${vac.id}" >View details&raquo;</a></p>
                    </div>
                </c:forEach>


<%--
                <c:forEach items="${ultimas}" var="vacante" varStatus="status">
                    <div class="col-lg-4">
                        <h3>Vacante: [${vacante.id}]</h3> 
                        <p class="text-danger">${vacante.nombre}</p>          
                        <p class="text-justify">${vacante.descripcion}</p>
                        <p><a class="btn btn-primary" href="vacante?action=ver&id=${vacante.id}" role="button">Ver Detalles&raquo;</a></p>
                    </div>
                </c:forEach>
--%>
            </div>

            <jsp:include page="footer.jsp" /> 

        </div>
    </div>    

</div> <!-- /container -->

</body>

<!-- Mirrored from itinajero.net:8080/vacantes/homepage by HTTrack Website Copier/3.x [XR&CO'2013], Fri, 11 May 2018 16:12:36 GMT -->
</html>