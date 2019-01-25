/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.view.CaixaControllerView;
import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Andrade
 */
public class TelaTrocoController implements Initializable {

    @FXML
    private TextField tfValorPago;
    @FXML
    private Label lblTroco;
    @FXML
    private Button btnCalculaTroco;
    @FXML
    private Button btnVoltarCaixa;

    CaixaControllerView pegaValor = new CaixaControllerView();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void voltar() {
        tfValorPago.setText("");
        projetoPOO.trocaTela("caixa");
    }

    @FXML
    public void alteralabel(KeyEvent event) {
        lblTroco.setText(String.valueOf(Float.parseFloat(tfValorPago.getText()) - pegaValor.getValorCompra()));
    }

}
