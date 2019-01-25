/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.factory;

import static com.projetoopoo.gerenciador.ManipuladorConfiguracoes.getProp;
import com.projetopoo.dao.FornecedorDAO;
import com.projetopoo.dao.FornecedorDAOMem;
import com.projetopoo.interfaces.Fornecedor_dao;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrade
 */
public class FornecedorFactory {

    public static Fornecedor_dao create() /*throws IOException*/ {
        String tipo;

        Properties prop = null;
        try {
            prop = getProp();
        } catch (IOException ex) {
            Logger.getLogger(FornecedorFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        tipo = prop.getProperty("configCompraDAO");

        if ("0".equals(tipo)) {

            return FornecedorDAOMem.getInstance();
        } else if ("1".equals(tipo)) {
            return FornecedorDAO.getInstance();
        }

        return null;
    }
}
