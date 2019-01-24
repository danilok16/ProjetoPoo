package com.projetopoo.view;


import javafx.fxml.FXML;
import javafx.scene.control.Button;


public  class TelaInicialControllerView {
  

    @FXML
    private Button btFinancieiro;

    @FXML
    private Button btAdmin;

    @FXML
    private Button btCaixa;
  
    
    
    public void chamaLoginCaixa(){
        projetoPOO.trocaTela("loginCaixa");
    }
    
    public void chamaAdmin(){
        projetoPOO.trocaTela("telaAdmin");
    }
}