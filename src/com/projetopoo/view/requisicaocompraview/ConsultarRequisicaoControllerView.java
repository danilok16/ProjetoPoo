/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.RequisicaoModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author dkaus
 */
public class ConsultarRequisicaoControllerView {

    @FXML
    private TextField tfQtd;

    @FXML
    private DatePicker dpDataDeEntrega;

    @FXML
    private TextField tfDescricao;

    @FXML
    private DatePicker dpDataDeSolicitacao;

    @FXML
    private TextField tfIdRequisitante;

    @FXML
    private TextField tfValorTotal;

    @FXML
    private TextField tfStatus;

    @FXML
    private TextField tfIdRequisicao;

    @FXML
    private Button btVoltar;
    RequisicaoController c = new RequisicaoController();

    @FXML
    private Button btPesquisar;

    @FXML
    void consultar() {

        RequisicaoModel r = c.consultar(tfIdRequisicao.getText());
        if (r != null) {
            tfDescricao.setText(r.getDescricao());
            tfValorTotal.setText(String.valueOf(r.getValorTotal()));
            tfStatus.setText(String.valueOf(r.getStatus()));
        } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("AVISO");
            dialogoInfo.setHeaderText("NÃO EXISTE EQUISIÇÃO COM ID: " + tfIdRequisicao.getText());
            dialogoInfo.showAndWait();
        }
    }

    public void backToMenuRequisicao() {
        MainRequisicaoDeCompra.trocaTela("menuRequisicao");

    }
}
