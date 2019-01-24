/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.chainofresponsibility.aprovarrequisicao;

import com.projetopoo.model.RequisicaoModel;

/**
 *
 * @author dkaus
 */
public class AprovadorNivel3 extends AprovarRequisicao {

    @Override
    public RequisicaoModel aprovar( RequisicaoModel requisicao) {
      if(requisicao.getAprovador().getNivelAcesso() == 3 && requisicao.getValorTotal() < 10000){
         requisicao.setStatus(5);
        }
        else if(proximoNivel != null && requisicao.getAprovador().getNivelAcesso() >= 3){
             requisicao.setStatus(4);
             return proximoNivel.aprovar(requisicao);
        }
    return requisicao;
    }

  
    
}
