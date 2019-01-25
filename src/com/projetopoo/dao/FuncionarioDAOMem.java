/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.interfaces.Funcionario_dao;
import com.projetopoo.model.FuncionarioModel;
import java.util.ArrayList;

/**
 *
 * @author Téo
 */
public class FuncionarioDAOMem implements Funcionario_dao {

    private static FuncionarioDAOMem instance;

    private FuncionarioDAOMem() {
    }

    public static FuncionarioDAOMem getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAOMem();
        }
        return instance;
    }

    @Override
    public void salvar(FuncionarioModel compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FuncionarioModel> recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ArrayList<FuncionarioModel> listp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
