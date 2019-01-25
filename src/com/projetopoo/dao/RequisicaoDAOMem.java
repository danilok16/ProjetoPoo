/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.interfaces.Requisicao_dao;
import com.projetopoo.model.RequisicaoModel;
import java.util.ArrayList;

/**
 *
 * @author Téo
 */
public class RequisicaoDAOMem implements Requisicao_dao {

    private static RequisicaoDAOMem instance;

    private RequisicaoDAOMem() {
    }

    public static RequisicaoDAOMem getInstance() {
        if (instance == null) {
            instance = new RequisicaoDAOMem();
        }
        return instance;
    }

    @Override
    public void salvar(RequisicaoModel compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RequisicaoModel> recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ArrayList<RequisicaoModel> listp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
