package com.projetopoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginCaixaControllerView {

    @FXML
    private TextField tfIdFuncionario;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private TextField tfIdCaixa;
    @FXML
    private Button btEntrar;

    public void ChamaCaixa() {
        projetoPOO.trocaTela("caixa");
    }
}
