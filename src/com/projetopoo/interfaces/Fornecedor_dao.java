/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.interfaces;

import com.projetopoo.model.DebitoModel;
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public interface Fornecedor_dao {
    void salvar(FornecedorModel compra);
    ArrayList<FornecedorModel> recuperar();
    void alterar(ArrayList<FornecedorModel> listp);
}
