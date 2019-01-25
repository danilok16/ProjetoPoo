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
public class AprovadorNivel1 extends AprovarRequisicao {

    @Override
    public RequisicaoModel aprovar(RequisicaoModel requisicao) {

        if (requisicao.getAprovador().getNivelAcesso() == 1) {
            requisicao.setStatus(2);

        } else if (proximoNivel != null) {
            return proximoNivel.aprovar(requisicao);
        }
        return requisicao;
    }

}
