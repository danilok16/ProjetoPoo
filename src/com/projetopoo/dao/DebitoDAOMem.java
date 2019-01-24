/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;
import com.projetopoo.interfaces.Debito_dao;
import com.projetopoo.model.DebitoModel;
import java.util.ArrayList;

/**
 *
 * @author Téo
 */
public class DebitoDAOMem implements Debito_dao{
    
    private static DebitoDAOMem instance;
    private DebitoDAOMem() {}
    
    public static DebitoDAOMem getInstance(){
        if (instance == null){
            instance = new DebitoDAOMem();
        }
        return instance;
    }
    
    @Override
    public void salvar(DebitoModel compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DebitoModel> recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ArrayList<DebitoModel> listp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
