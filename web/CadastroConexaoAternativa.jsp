<%-- 
    Document   : Cadastro
    Created on : Sep 15, 2015, 11:00:37 AM
    Author     : Samuel.Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela de Cadastro</title>
        <link href="boostrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Tela Cadastro de Pipoca JSP - JSP</h1>
            <div class="row">

                <div class="col-md-6">
                    <form action="NovaConexao.jsp" method="POST" id="cadastro">
                        <input type="hidden" name="cmd" value="cad">                    
                        <label>Codigo: </label>
                        <input type="text" required name="codigo" class="form-control"><br>
                        <label>Descrição: </label>
                        <input type="text" required name="descricao" class="form-control"><br>

                        <label>Preço: </label>
                        <input type="text" required name="preco" class="form-control"><br>
                        <input type="submit" value="cadastrar" class="btn btn-sm btn-success btn-block">
                    </form>
                </div>
                <div class="col-md-6">
                    <form action="NovaConexao.jsp" method="POST" id="consulta">
                        <input type="hidden" name="cmd" value="conf-taxa">
                        <label>taxa de entrega:</label>
                        <input type="text" name="codigo" class="form-control" required><br>
                        <input type="submit" value="verifica" class="btn btn-sm btn-warning">
                    </form>
                </div>

            </div>
            <hr>
            <% if (session.getAttribute("msg") != null)
                {%>
            <div class="alert alert-danger text-center">
                <strong><%= session.getAttribute("msg")%></strong>
            </div>
            <%}%>
            <hr>
            <a href="Cadastro.jsp" class="btn btn-sm btn-primary" target="new">Cadastro com WebServlet</a>
        </div>
            
    </body>
</html>
<%
// removo a mensagem para que sempre eu tenha uma nova mensagem
session.removeAttribute("msg");
%>