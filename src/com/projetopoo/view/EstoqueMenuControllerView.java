/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class EstoqueMenuControllerView implements Initializable {

    @FXML
    private Button btCriarRequisicao;
      @FXML
    private Button btAlterarRequisicao;

    @FXML
    private Button btControleItens;
    
    
    @FXML
    private Button btVoltar;

    @FXML
    private Label lblTitulo;
    
     private static Stage stage;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void startItemMenu() throws Exception{
       projetoPOO.trocaTela("ItemMenu");

    }
        public void backToAdiminMenu(){
        projetoPOO.trocaTela("telaAdmin");
        
        
}
         public void startMenuRequisicao() throws Exception{
       projetoPOO.trocaTela("requisicao");
         }
 
    }
     
    
