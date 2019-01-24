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
public class AprovadorNivel2 extends AprovarRequisicao {

    @Override
    public RequisicaoModel aprovar(RequisicaoModel requisicao) {
        if(requisicao.getAprovador().getNivelAcesso() == 2 && requisicao.getValorTotal() < 2000){
           requisicao.setStatus(5);
           
        }
        else if(proximoNivel != null && requisicao.getAprovador().getNivelAcesso() >= 2){
             requisicao.setStatus(3);
            return proximoNivel.aprovar( requisicao);
        }
       return requisicao;
    }
    
  
}
