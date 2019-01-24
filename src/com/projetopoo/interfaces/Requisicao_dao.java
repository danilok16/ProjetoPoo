/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.interfaces;

import com.projetopoo.model.RequisicaoModel;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public interface Requisicao_dao {
    void salvar(RequisicaoModel compra);
    ArrayList<RequisicaoModel> recuperar();
    void alterar(ArrayList<RequisicaoModel> listp);
}
