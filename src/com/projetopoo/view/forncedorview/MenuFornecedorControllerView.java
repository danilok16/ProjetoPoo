package com.projetopoo.view.forncedorview;

import com.projetopoo.view.projetoPOO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuFornecedorControllerView {

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btRemover;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btConsultar;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lblTitulo;

    public void startCadastrar() {
        MainFornecedor.trocaTela("cadastrarFornecedor");
    }

    public void startRemover() {
        MainFornecedor.trocaTela("removerFornecedor");
    }

    public void startAlterar() {
        MainFornecedor.trocaTela("alterarFornecedor");
    }

    public void startConsultar() {
        MainFornecedor.trocaTela("consultarFornecedor");
    }

    public void voltar() {
        projetoPOO.trocaTela("telaAdmin");
    }

}
