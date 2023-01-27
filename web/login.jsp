<%-- 
    Document   : login
    Created on : 09/12/2020, 12:19:39 PM
    Author     : BRUman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Como Administrador</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>       
    </head>
    
    <body>
        
        <div class="container">
            
            <center>      
                <img src="images/lock.png" alt="Imagen lock"/><br> 
            </center>
          
        
            <form class="form-signin" method="post" action="admin">
                <br>
                
                <h2 class=" form-signin-heading">Ingreso al sistema</h2><br>
                    
                <label  for="user" class="sr-only" >Nombre del usuario: </label>
                <input class="form-control" type="text" id="user" name="user" placeholder="Escriba nombre de usuario" required="">
                <label for="pass" class="sr-only" >Password: </label>
                <input class="form-control" type="password" id="pass" name="pass" placeholder="Escriba su password" required="">
                
                <p class="text-danger"> ${message} </p>
                
                <button class="btn btn-lg btn-block btn-primary" type="submit">Login</button>
            </form>
        </div>
        
    </body>
    
</html>
