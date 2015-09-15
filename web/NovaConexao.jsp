<%-- 
    Document   : Cadastro
    Created on : Sep 15, 2015, 11:00:37 AM
    Author     : Samuel.Jesus
--%>


<%@page import="acao.PipocaConexao"%>
<%@page import="model.Pipoca"%>
<%
    String cmd = request.getParameter("cmd");
    String msg = "";
    PipocaConexao conn = new PipocaConexao();
    if (cmd.equals("cad"))
    {
        msg = conn.Cadastra(new Pipoca(
                Integer.parseInt(request.getParameter("codigo")),
                request.getParameter("descricao"),
                Double.parseDouble(request.getParameter("preco"))));

    } else if (cmd.equals("conf-taxa"))
    {
        msg = conn.RetornaTaxaDeEntrega(Integer.parseInt(request.getParameter("codigo")));

    }
    conn.CriaMensagemSessao(msg, request);

    response.sendRedirect("CadastroConexaoAternativa.jsp");
%>
