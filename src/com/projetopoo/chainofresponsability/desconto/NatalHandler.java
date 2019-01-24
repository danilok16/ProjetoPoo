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
public class NatalHandler extends Desconto{

    @Override
    public void desconto(ProdutoModel item) {
      if(now.getDayOfMonth() == 25 && now.getMonthValue() == 12){
           item.setDesconto(item.getDesconto()+15);
       }
       if(proximo != null){
           proximo.desconto(item);
       }
    }
    
}
