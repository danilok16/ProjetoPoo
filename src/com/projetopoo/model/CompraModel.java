package com.projetopoo.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CompraModel implements Serializable{
    private String idCompra;
    private int qtdItenCompra;
    private String data;
    private float valorTot;
    private ArrayList <ProdutoModel> itens;
    private boolean fechada;
    private boolean paga;

    public CompraModel(String idCompra) {
        this.idCompra = idCompra;
        this.qtdItenCompra = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        this.data = sdf.format(new Date());
        this.valorTot = 0;
        this.fechada = false;
        this.paga = false;
        //this.itens = itens;
    }
    
    public CompraModel() {
        this.idCompra = "";
        this.qtdItenCompra = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        this.data = sdf.format(new Date());
        this.valorTot = 0;
        this.fechada = false;
        this.paga = false;
        //this.itens = itens;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public int getQtdItenCompra() {
        return qtdItenCompra;
    }

    public void setQtdItenCompra(int qtdItenCompra) {
        this.qtdItenCompra = qtdItenCompra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValorTot() {
        return valorTot;
    }

    public void setValorTot(float valorTot) {
        this.valorTot = valorTot;
    }

    public ArrayList<ProdutoModel> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ProdutoModel> itens) {
        this.itens = itens;
    }

    public boolean getFechada() {
        return fechada;
    }

    public void setFechada(boolean fechada) {
        this.fechada = fechada;
    }

    public boolean getPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }
    
    
}
