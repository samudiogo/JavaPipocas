/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author Samuel.Jesus
 */

public class PipocaDao {
    /**
     * Método de pesistência 
     * @param pipoca objeto à ser persistido
     * @return mensagem de sucesso ou erro de cadastro
     */
    public String Cadastrar(Object pipoca) {
        try {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            em.persist(pipoca);
            utx.commit();
            return "Cadastrado com sucesso!";
        } catch (Exception e) {
            Logger.getLogger(PipocaDao.class.getName()).log(Level.SEVERE, null, e);
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }

}
