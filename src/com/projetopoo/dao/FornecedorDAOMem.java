/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;
import com.projetopoo.interfaces.Fornecedor_dao;
/**
 *
 * @author Téo
 */
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;/**
 *
 * @author Téo
 */
public class FornecedorDAOMem implements Fornecedor_dao{

    private static FornecedorDAOMem instance;
    private FornecedorDAOMem() {}
    
    public static FornecedorDAOMem getInstance(){
        if (instance == null){
            instance = new FornecedorDAOMem();
        }
        return instance;
    }
    @Override
    public void salvar(FornecedorModel compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FornecedorModel> recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ArrayList<FornecedorModel> listp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
