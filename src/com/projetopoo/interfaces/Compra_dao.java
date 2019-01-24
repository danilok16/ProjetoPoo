/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.interfaces;

import com.projetopoo.model.CompraModel;
import java.util.ArrayList;


public interface Compra_dao {
    void salvar(CompraModel compra);
    ArrayList<CompraModel> recuperar();
    void alterar(ArrayList<CompraModel> listp);
}
