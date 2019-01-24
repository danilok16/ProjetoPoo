/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.interfaces.Item_dao;
import com.projetopoo.model.ProdutoModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class ItemDAOMem implements Item_dao{
    
    
    private static ItemDAOMem instance;
    private ItemDAOMem(){}
    
    public static ItemDAOMem getInstance(){
        if(instance ==null){
            instance = new ItemDAOMem();
        }
        return instance;
    }

    @Override
    public void salvar(ProdutoModel compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProdutoModel> recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ArrayList<ProdutoModel> listp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
