/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.interfaces;

import com.projetopoo.model.DebitoModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public interface Debito_dao {

    void salvar(DebitoModel compra);

    ArrayList<DebitoModel> recuperar();

    void alterar(ArrayList<DebitoModel> listp);
}
