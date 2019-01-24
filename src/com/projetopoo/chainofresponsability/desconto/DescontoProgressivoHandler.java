/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.chainofresponsability.desconto;

import com.projetopoo.model.ItemModel;
import com.projetopoo.model.ProdutoModel;

/**
 *
 * @author dkaus
 */
public class DescontoProgressivoHandler extends Desconto{

   

    @Override
    public void desconto(ProdutoModel item) {
        if(item.getQtdDesejada()>=5){
           item.setDesconto(item.getDesconto()+10);
       }
       if(proximo != null){
           proximo.desconto(item);
       }
    }
    
    
    
}
