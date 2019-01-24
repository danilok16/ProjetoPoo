/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author dkaus
 */
public class MenuRequisicaoCompraControllerView implements Initializable{
   @FXML
    private Button btCriarRequisicao;

    @FXML
    private Button btAlterarRequisicao;

    @FXML
    private Button btConsultarRequisicao;

    @FXML
    private Button btAprovarRequisicao;

    @FXML
    private Button btVoltar;

   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public void startCriarRequisicao(){
         MainRequisicaoDeCompra.trocaTela("requisicao");
    }
       public void startConsultarRequisicao(){
         MainRequisicaoDeCompra.trocaTela("consultarRequisicao");
    }
        public void startAlterarRequisicao(){
         MainRequisicaoDeCompra.trocaTela("alterarRequisicao");
    }
         public void startAprovarRequisicao(){
         MainRequisicaoDeCompra.trocaTela("aprovarRequisicao");
    }
          public void backToMenuEstoque(){
        projetoPOO.trocaTela("estoqueMenu");
    }
         
}
