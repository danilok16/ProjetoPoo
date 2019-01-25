package com.projetopoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConsultarProdutoControllerView {
    @FXML
    private Label lbPreco;
    @FXML
    private Label lbDescricao;
    @FXML
    private TextField tbCodProduto;
    @FXML
    private Button btConsultar;
    @FXML
    private Button btVoltar;
    
    public void voltar(){
        projetoPOO.trocaTela("caixa");
    }

}
