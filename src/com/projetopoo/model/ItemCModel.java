/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class ItemCModel extends ProdutoModel implements Serializable {
    
    private int qtdEstoque;
    
    private ArrayList<ItemModel> conjunto;
    
    public ItemCModel(String validade, String idItem, int qtdDesejada) {
        super(validade, idItem, qtdDesejada);
    }

    @Override
    public int getQtdEstoque() {
        return qtdEstoque;
    }

    @Override
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public float getPreco() {
        for(ItemModel s:this.conjunto){
            this.preco += s.getPreco();
        }
        return preco;
    }

    public ArrayList<ItemModel> getConjunto() {
        return conjunto;
    }

    public void setConjunto(ArrayList<ItemModel> conjunto) {
        this.conjunto = conjunto;
    }
}
