<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/stilos.css" rel="stylesheet" type="text/css"/>
        <title>LOGIN</title>
    </head>
    <body>
        <div class="container col-lg-3">
        <form action="acceso.do" method="POST">
            <div class="form-group text-center">
                    <p><strong>Bienvenid@</strong></p>
                    <img src="iconos/usuario1.png" height="80" width="80"/>
                    <p><strong>Ingrese sus credenciales</strong></p>
                </div>
            <div class="form-group">
                <label>Usuario:</label>
                <input class="form-control" type="text" name="txtusuario" placeholder="&#128100;Usuario">
                    
            </div>
                <div class="form-group">
                    <label>Contraseña:</label>
                    <input type="password" name="txtcontrasenia" class="form-control" placeholder="&#128272;Contraseña">
                </div>
                <% 
                   
                   if(request.getAttribute("mensaje")!=null)
                   {
                       String cadena = "";
                       cadena = String.valueOf(request.getAttribute("mensaje"));
                       %>
                       <center><font color="red"><b><%=cadena%></b></font></center>
                       
                       <center><a href="recuperar.jsp"><font color="blue">Recuperar contraseña</b></font></a></center>
                       
                       <%
                   }
                    else
                    {
                            %>
                        <center><font color="red"><b>...</b></font></center>
                        <%
                    }

                  
                  
                %>
                
                <input class="btn btn-danger btn-block" type="submit" name="accion" value="INICIAR">
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
