/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeItemOpcoesControllerView implements Initializable {

    @FXML
    private Label lblTitulo;

    @FXML
    private Button btCadatrarItem;

    @FXML
    private Button btListarItens;

    @FXML
    private Button btAlterarItem;

    @FXML
    private Button btVoltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void startCadastroItem() {
        MainItem.trocaTela("cadastroItem");
    }

    public void startListarItem() {
        MainItem.trocaTela("listarItem");
    }

    public void startAlterarItem() {
        MainItem.trocaTela("alterarItem");
    }

    public void backToMenuEstoque() {
        projetoPOO.trocaTela("estoqueMenu");
    }

}
