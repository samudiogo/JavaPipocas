package acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PipocaDao;
import javax.servlet.http.HttpSession;
import model.Pipoca;

/**
 *
 * @author Samuel.Jesus
 */
@WebServlet(urlPatterns = "/acao/Conexao")
public class PipocaConexao extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String cmd = req.getParameter("cmd");
        String msg = "";
        //Controlo o fluxo de atividade de acordo com comando enviado pelo formulário:
        switch (cmd)
        {
            case "cad": //cadastro
                msg = this.Cadastra(new Pipoca(
                        Integer.parseInt(req.getParameter("codigo")),
                        req.getParameter("descricao"),
                        Double.parseDouble(req.getParameter("preco"))));
                break;
            case "conf-taxa": //verifica a taxa
                msg = this.RetornaTaxaDeEntrega(Integer.parseInt(req.getParameter("codigo")));
                break;
        }
        this.CriaMensagemSessao(msg, req);
        resp.sendRedirect("../Cadastro.jsp");
    }

    /**
     * Método responsável pelo acesso à camada DAO e chamar método de cadastro
     *
     * @param pipoca objeto à ser persistido
     * @return retorna uma mensagem de sucesso ou erro. (string)
     */

    public String Cadastra(Object pipoca)
    {
        PipocaDao dao = new PipocaDao();
        return dao.Cadastrar(pipoca);
    }

    /**
     * retorna o valor da taxa de entrega, conforme informado no parametro
     *
     * @param codigo numero informado pelo usuario
     * @return valor da taxa de entrega
     */
    public String RetornaTaxaDeEntrega(int codigo)
    {

        switch (codigo)
        {
            case 1:
                return "R$ 5,00";
            case 2:
                return "R$ 6,00";
            case 3:
                return "R$ 7,00";
            case 4:
                return "R$ 8,00";
            case 5:
            case 6:
                return "R$ 5,00";
            case 7:
            case 8:
            case 9:
                return "R$ 10,00";
        }
        if (codigo >= 10 && codigo <= 20)
        {
            return "R$ 15,00";
        } else if (codigo >= 25 && codigo <= 35)
        {
            return "R$ 20,00";
        }

        return "";
    }

    public void CriaMensagemSessao(String Mensagem, HttpServletRequest req)
    {
        HttpSession session = req.getSession(true);
        session.setAttribute("msg", Mensagem);
    }

}
