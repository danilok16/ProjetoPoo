/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.factory;

import static com.projetoopoo.gerenciador.ManipuladorConfiguracoes.getProp;
import com.projetopoo.dao.DebitoDAO;
import com.projetopoo.dao.DebitoDAOMem;
import com.projetopoo.interfaces.Debito_dao;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrade
 */
public class DebitoFactory {

    public static Debito_dao create() /*throws IOException*/ {
        String tipo;

        Properties prop = null;
        try {
            prop = getProp();
        } catch (IOException ex) {
            Logger.getLogger(DebitoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        tipo = prop.getProperty("configCompraDAO");

        if ("0".equals(tipo)) {
            return DebitoDAOMem.getInstance();
        } else if ("1".equals(tipo)) {
            return DebitoDAO.getInstance();
        }

        return null;
    }

}
