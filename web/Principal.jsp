<%-- 
    Document   : Principal
    Created on : 11/04/2013, 08:25:16 PM
    Author     : FGulfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilo/StPrincipal.css" rel="stylesheet" type="text/css"/>
        <title>Principal</title>
    </head>
    <body>
        
        <h:form>
            <header id="hp">
            Usuario: <h:outputText value="#{loginEBean.usuario.nick}"/>
            <h:commandLink value=" LogOut" action="#{loginEBean.regresar()}"/>
            </header>
        </h:form>
        
        <h:form id="fp">
            
            <table id="tabla">
                <tr>
                    <td><article>Ventas</article></td>
                    <td><article>Compras</article></td>
                    <td><article>Inventario</article></td>
                </tr>
                <tr>
                    <td><article>Cartera</article></td>
                    <td><article>Factura</article></td>
                    <td><article>Configuracion</article></td>
                </tr>
                
            </table>
            
        </h:form>
    </body>
</html>
</f:view>
