/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.interfaces;

import com.projetopoo.model.*;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public interface Item_dao {

    void salvar(ProdutoModel compra);

    ArrayList<ProdutoModel> recuperar();

    void alterar(ArrayList<ProdutoModel> listp);
}
