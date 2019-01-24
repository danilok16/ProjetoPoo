package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class ProdutoModel implements Serializable{
     public enum Categoria{
        BEBIDAS,BEBIDASALCOOLICAS,MERCEARIA, ACOUGUE, FRIOS, HORTIFRUITI, LIMPEZA, COSMETICOS
    }
    private String marca;
    private String tipo;
    private String validade;
    private String idItem;
    private String descricao;
    private int qtdDesejada;
    protected float preco;
    private String posicaoEstoque;
    private ArrayList<FornecedorModel> fornecedor;
    private Categoria categoria;
    private float desconto;
 
    public ProdutoModel(String validade, String idItem, int qtdDesejada) {
        this.validade = validade;
        this.idItem = idItem;
        this.qtdDesejada = qtdDesejada;
    }

   
    
    public ProdutoModel(String validade, String idItem, String descricao, float preco, String posicaoEstoque, ArrayList<FornecedorModel> fornecedor) {
        this.validade = validade;
        this.idItem = idItem;
        this.descricao = descricao;
        this.preco = preco;
        this.posicaoEstoque = posicaoEstoque;
        this.fornecedor = fornecedor;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    public String getPosicaoEstoque() {
        return posicaoEstoque;
    }

    public void setPosicaoEstoque(String posicaoEstoque) {
        this.posicaoEstoque = posicaoEstoque;
    }
    
     public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    
    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }
    
    public int getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(int qtdDesejada) {
        this.qtdDesejada = qtdDesejada;
    }
    
    public abstract float getPreco();

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public ArrayList<FornecedorModel> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(ArrayList<FornecedorModel> fornecedor) {
        this.fornecedor = fornecedor;
    }
     public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract int getQtdEstoque();
    
    public abstract void setQtdEstoque(int qtdEstoque);

    public String detalhes() {
        return "==================================================\n" +
                " Produto{ " +
                "marca = '" + marca + '\'' +
                ", tipo = '" + tipo + '\'' +
                ", validade = '" + validade + '\'' +
                '}';
    }
}
