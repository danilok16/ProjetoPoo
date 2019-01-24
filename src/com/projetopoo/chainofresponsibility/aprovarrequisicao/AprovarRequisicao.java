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
public abstract class AprovarRequisicao {
    protected AprovarRequisicao proximoNivel;
   
    
    public void setProximoNivel(AprovarRequisicao proximoNivel){
        this.proximoNivel = proximoNivel;
    }
    
     public abstract RequisicaoModel aprovar(RequisicaoModel requisicao);
    
}
