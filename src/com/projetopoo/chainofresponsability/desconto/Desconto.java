/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.chainofresponsability.desconto;

import com.projetopoo.model.ItemModel;
import com.projetopoo.model.ProdutoModel;
import java.time.LocalDateTime;

/**
 *
 * @author dkaus
 */
public abstract class Desconto {
    protected Desconto proximo;
    protected LocalDateTime now = LocalDateTime.now();
    
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }
    
      public abstract void desconto(ProdutoModel item);
}