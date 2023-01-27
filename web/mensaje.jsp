<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="header.jsp" />
        <title>Administración del Sistema</title>
    </head>
    <body>

        <div class="container">

            <jsp:include page="nav-admin.jsp" />
            <br>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Sistema</h3>          
                </div>
                <div class="panel-body">
                    <h4>${message}</h4>
                </div>
            </div>

            <jsp:include page="footer.jsp" />

        </div> <!-- /container -->

    </body>
</html>
