<%-- 
    Document   : ofertas
    Created on : 30-jul-2019, 17:29:11
    Author     : danielmej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Acerca De...</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<%= request.getContextPath()%>/PaquetesServlet?accion=index">Condor Trips</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="<%= request.getContextPath()%>/PaquetesServlet?accion=ofertas">Ofertas Especiales</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<%= request.getContextPath()%>/PaquetesServlet?accion=listar">Tours Turisticos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<%= request.getContextPath()%>/PaquetesServlet?accion=acerca">Acerca de...</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Version 1.0</a>
            </li>
          </ul>
        </div>
      </nav>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
              <h1 class="display-4">Ofertas Especiales</h1>
              <p class="lead">para que el dinero no sea una excusa</p>
            </div>
          </div>
            
         <div class="w3-card-4">
            <header class="w3-container w3-blue">
              <h1>20% Por el mes de Agosto</h1>
            </header>

            <div class="w3-container">
              <p>Descripción: Se aplica un 20% de descuento a todas las compras de la agencia durante todo el mes de Agosto. Aplican condiciones y restricciones</p>
            </div>
        </div> 
            
        <div class="w3-card-4">
            <header class="w3-container w3-blue">
              <h1>35% Si compras un paquete con un amigo o familiar</h1>
            </header>
            <div class="w3-container">
              <p>Descripción: Si traes un amigo tuyo o familiar para ser parte de la familia condor trips, obtienes un 35% de descuento para un viaje todo incluido.</p>
            </div>
        </div>    
            
        <div class="w3-card-4">
            <header class="w3-container w3-blue">
              <h1>10% Si pagas con tu tajerta condor Trips</h1>
            </header>
            <div class="w3-container">
              <p>Descripción: Si realizar cualquier compra con la tarjeta condor Trips, obtienes un 10% de descuento en tu compra.</p>
            </div>
        </div> 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>  
    </body>
</html>
