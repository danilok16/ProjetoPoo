package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemModel extends ProdutoModel implements Serializable{
    private int qtdEstoque;
    private ArrayList<FornecedorModel> fornecedorList;
    private FornecedorModel fonecedor;
 

   
    
    public ItemModel(String idItem, int qtdDesejada) {//
        super("10/10/2200", idItem, qtdDesejada);
    }
    
    public ItemModel(String idItem, int qtdEstoque, float preco, String descricao, String validade, String posicaoEstoque, ArrayList fornecedorList) {
       super(validade, idItem,descricao, preco,posicaoEstoque, fornecedorList);
        this.qtdEstoque = qtdEstoque;
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
        return preco;
    }
    
    @Override
    public String toString() {
        return "IdItem : " + this.getIdItem() + "\nDescrição: " + this.getDescricao();
    }
}

