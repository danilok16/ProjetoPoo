/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;


import com.projetopoo.command.PagamentoCommand;
import com.projetopoo.factory.CompraFactory;
import com.projetopoo.interfaces.Compra_dao;
import java.util.ArrayList;
import com.projetopoo.model.CompraModel;

/**
 *
 * @author Andrade
 */


public class CompraController {
   
    public static ArrayList<CompraModel> restaurarCompras(){
        ArrayList<CompraModel> c = new ArrayList();// c eh o array de compras
        Compra_dao cd = CompraFactory.create();//cd onde está chamando os metodos do DAO
        c = cd.recuperar();
        return c;
    }
    /* public  ArrayList<CompraModel> recuperarCompras(){
        ArrayList<CompraModel> compras = new ArrayList();// c eh o array de compras
        CompraDAO cd = new CompraDAO();//cd onde está chamando os metodos do DAO
        c =cd.restaurarCompra();
        return c;
    }*/
    
    public static CompraModel getUltimaCompra(){ //Retorna o valor total da última compra
        ArrayList<CompraModel> ultimasCompras = restaurarCompras();
        return ultimasCompras.get(ultimasCompras.size() - 1);
    }
    
    public static void pagarCompra(CompraModel compra, PagamentoCommand formaPagamento){
        if(formaPagamento.processarCompra(compra)){
            compra.setPaga(true);
        }
        alterarCompra(compra);
    }
    
    public static void alterarCompra(CompraModel compra){
        Compra_dao cd = CompraFactory.create();
        ArrayList <CompraModel> compras = restaurarCompras();
        int i;
        for(i = 0; i < compras.size(); i++){
            if(compras.get(i).getIdCompra().equals(compra.getIdCompra())){
                compras.set(i, compra);
                cd.alterar(compras);
            }
        }
    }
    
    public static void removerCompra(String id){
        int tamanho;
        CompraModel compra;
        ArrayList<CompraModel> lista;
        lista= restaurarCompras();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                compra=lista.get(i);                
                if(id.equals(compra.getIdCompra())){
                    lista.remove(i);
                    return;
                }
            }
        }    
    }
    public static void inserirCompra (CompraModel compra){
        Compra_dao cd = CompraFactory.create();
        CompraModel comp = new CompraModel();
        //compra.setIdCompra(GeraIdCompra());
        if(compra.getFechada() == true){
            compra.setIdCompra(CompraController.GeraIdCompra());
            cd.salvar(compra);
            System.out.println(compra.getItens().get(0).getDescricao());
        }else{
            ArrayList<CompraModel> ultima = cd.recuperar();
            comp = CompraController.ConsultaCompra(compra.getIdCompra());
            ultima.remove(comp);
            ultima.add(compra);
            cd.alterar(ultima);
        }
    }
    public static String GeraIdCompra(){
        int novoId= 0;
        CompraModel ultimo;
        ArrayList<CompraModel> lista;
        lista= restaurarCompras();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(ultimo.getIdCompra());
            
            novoId= i +1;
            
        }
        String t = String.valueOf(novoId);
        return t;
    }
    public static CompraModel ConsultaCompra(String id){
        int tamanho;
        CompraModel compra;
        ArrayList<CompraModel> lista;
        lista= restaurarCompras();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                compra=lista.get(i);                
                if(id.equals(compra.getIdCompra())){
                    return lista.get(i);
                }
            }
        }
        return null;
    }
    
      
  public float somarTotalReceitas(String data){
        float total = 0;
        Compra_dao dao = CompraFactory.create();
       ArrayList<CompraModel> receita = new ArrayList();
       receita = dao.recuperar();
        for(int i = 0; i<receita.size(); i++){
             if((data.charAt(3) == receita.get(i).getData().charAt(3)) && ((data.charAt(4) == receita.get(i).getData().charAt(4)))){
                 if((data.charAt(6) == receita.get(i).getData().charAt(6)) && ((data.charAt(6) == receita.get(i).getData().charAt(6)))){
                     if((data.charAt(7) == receita.get(i).getData().charAt(7)) && ((data.charAt(7) == receita.get(i).getData().charAt(7)))){
                        if((data.charAt(8) == receita.get(i).getData().charAt(8)) && ((data.charAt(8) == receita.get(i).getData().charAt(8)))){
                           if((data.charAt(9) == receita.get(i).getData().charAt(9)) && ((data.charAt(9) == receita.get(i).getData().charAt(9)))){
           total +=(receita.get(i).getValorTot());
                        }
                     }
                 }
             }
             }
        }
        return total;
    }
 
}
// int i = Integer.parseInt(str);
    // String t = String.valueOf(123);

