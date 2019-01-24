package com.projetopoo.controler;

import com.projetopoo.view.projetoPOO;

import javafx.fxml.FXML;

import javafx.scene.control.Button;


public  class TelaInicialController {
  

    @FXML
    private Button btFinancieiro;

    @FXML
    private Button btEstoque;

    @FXML
    private Button btCaixa;
  
    
    
    public void chamaLoginCaixa(){
        projetoPOO.trocaTela("loginCaixa");
    }
}