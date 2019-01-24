/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.interfaces.Compra_dao;
import com.projetopoo.model.CompraModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class CompraDAOMem implements Compra_dao{

    private static CompraDAOMem instance;
    private CompraDAOMem(){}
    
    public static CompraDAOMem getInstance(){
        if(instance ==null){
            instance = new CompraDAOMem();
        }
        return instance;
    }
    
    @Override
    public void salvar(CompraModel compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompraModel> recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ArrayList<CompraModel> listp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
