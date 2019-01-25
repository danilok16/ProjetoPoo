/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.factory;

import static com.projetoopoo.gerenciador.ManipuladorConfiguracoes.getProp;
import com.projetopoo.dao.FuncionarioDAO;
import com.projetopoo.dao.FuncionarioDAOMem;
import com.projetopoo.interfaces.Funcionario_dao;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Téo
 */
public class FuncionarioFactory {

    public static Funcionario_dao create() {
        String tipo;

        Properties prop = null;
        try {
            prop = getProp();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        tipo = prop.getProperty("configFuncionarioDAO");

        if ("0".equals(tipo)) {
            return FuncionarioDAOMem.getInstance();
        } else if ("1".equals(tipo)) {
            return FuncionarioDAO.getInstace();
        }

        return null;
    }
}
