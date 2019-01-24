
package com.projetopoo.controler;

import com.projetopoo.view.projetoPOO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginCaixaController {
    
    //Bruno Passou por aqui!

    @FXML
    private TextField tfIdFuncionario;

    @FXML
    private PasswordField tfSenha;

    @FXML
    private TextField tfIdCaixa;
    
    @FXML
    private Button btEntrar;
    
    public void ChamaCaixa(){
        projetoPOO.trocaTela("caixa");
    }
}
