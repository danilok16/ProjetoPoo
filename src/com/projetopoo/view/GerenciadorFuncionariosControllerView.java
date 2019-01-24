package com.projetopoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GerenciadorFuncionariosControllerView {

    @FXML
    private Label lblTitulo;

    @FXML
    private Button btConsultar;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btRemover;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btVoltar;

    public void CadastrarFuncionario(){
        projetoPOO.trocaTela("cadastroFuncionario");
    }

    public void ConsultarFuncionario(){
        projetoPOO.trocaTela("exibirFuncionario");
    
    }
    public void AlterarFuncionario(){
        projetoPOO.trocaTela("alterarFuncionario");
    }
    public void RemoverFuncionario(){
        projetoPOO.trocaTela("removerFuncionario");
    }
    public void Voltar(){
        projetoPOO.trocaTela("telaAdmin");
    }
}
