/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import static com.projetopoo.controler.CompraController.restaurarCompras;
import com.projetopoo.model.FluxoDeCaixaModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkaus
 */
public class FluxoDeCaixaController {
   //  ArrayList<FluxoDeCaixaModel> fluxoDeCaixaList= new ArrayList();
     
     
    /*public ArrayList<FluxoDeCaixaModel> recuperarLista(){
       FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
      fluxoDeCaixaList = dao.recuperarFluxoDeCaixa();
      return fluxoDeCaixaList;
    }
    
    public void salvarArrayList(ArrayList<FluxoDeCaixaModel> listp){
    FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
    dao.salvarAlteracao(listp);
}
    */
    
    public FluxoDeCaixaModel criarFluxoDeCaixa(String data, String descricao, String tipo){

         FluxoDeCaixaModel fluxo  = new FluxoDeCaixaModel();
         DebitoController despesa = new DebitoController();
          CompraController receita = new CompraController();
     
          
            if((data.charAt(3) == '0') && (data.charAt(4) == '1')){
               fluxo.setData("JANEIRO");
            }
             else  if((data.charAt(3) == '0') && (data.charAt(4) == '2')){
               fluxo.setData("FEVEREIRO");
            }  
           else  if((data.charAt(3) == '0') && (data.charAt(4) == '3')){
               fluxo.setData("MARÇO");
            }
           else  if((data.charAt(3) == '0') && (data.charAt(4) == '4')){
               fluxo.setData("ABRIL");
            }
           else  if((data.charAt(3) == '0') && (data.charAt(4) == '5')){
               fluxo.setData("MAIO");
            }
           else  if((data.charAt(3) == '0') && (data.charAt(4) == '6')){
               fluxo.setData("JUNHO");
            }
            else  if((data.charAt(3) == '0') && (data.charAt(4) == '7')){
               fluxo.setData("JULHO");
            }
              else  if((data.charAt(3) == '0') && (data.charAt(4) == '8')){
               fluxo.setData("AGOSTO");
            }
           else  if((data.charAt(3) == '0') && (data.charAt(4) == '9')){
               fluxo.setData("SEMTEMBRO");
            }
             else  if((data.charAt(3) == '1') && (data.charAt(4) == '0')){
               fluxo.setData("OUTUBRO");
            }
              else  if((data.charAt(3) == '1') && (data.charAt(4) == '1')){
               fluxo.setData("NOVEMBRO");
            }
                else  if((data.charAt(3) == '1') && (data.charAt(4) == '2')){
               fluxo.setData("DEZEMBRO");
            }
               
               fluxo.setDescricao(descricao);
               if(descricao.equalsIgnoreCase("DESPESAS VARIÁVEIS")){

               fluxo.setTotal(despesa.somarTotalDespesas(data));
               }
               else if(descricao.equalsIgnoreCase("VENDAS")){
               fluxo.setTotal(receita.somarTotalReceitas(data));
               }
               else{
                   fluxo.setTotal(receita.somarTotalReceitas(data)-despesa.somarTotalDespesas(data));
               }
                fluxo.setTipo(tipo);
               fluxo.setDespesas(despesa.recuperarLista());
               fluxo.getDespesas();
               
      
       // FluxoDeCaixaModel fluxo  = new FluxoDeCaixaModel("", despesa.somarTotalDespesasPorMes(data), receita.somarTotalReceitas(), (receita.somarTotalReceitas() - despesa.somarTotalDespesasPorMes(data)));
      
       
      // fluxo.setTotalRecita(0);
    
     //  fluxo.setSaldoFinal(receita.somarTotalReceitas() - despesa.somarTotalDespesas(data));
     
      //  fluxo.setReceitas(restaurarCompras());
        
        return fluxo;
    }
    

   
    
  /*public void salvarAlteracao(ArrayList<DebitoModel> listp){
      if(listp != null){
          DebitoDAO dao = new DebitoDAO();
          dao.salvarAlteracao(listp);
      }
    }*/
    
    
    
    
}
