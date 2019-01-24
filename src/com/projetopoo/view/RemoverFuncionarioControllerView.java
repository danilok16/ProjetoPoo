package com.projetopoo.view;

import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.model.FuncionarioModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RemoverFuncionarioControllerView {

    @FXML
    private Button btBuscar;

    @FXML
    private Button btRemover;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private Button btCancelar;

    @FXML
    private Label lbValidacao;

    @FXML
    void buscarFuncionario() {
        FuncionarioModel f;
        CadastroFuncionarioController cf = new CadastroFuncionarioController();
        f= cf.ConsultaFuncionario(tfCPF.getText());
        if(f==null){
            lbValidacao.setText("NÃO ENCONTRADO!");
            btRemover.setDisable(true);
            
        }
        else{
            tfNome.setText(f.getNome());
            btRemover.setDisable(false);
            lbValidacao.setText("");
        }

    }
    @FXML
    void limpar(){
        tfNome.clear();
    }
    @FXML
    void remover() {
        CadastroFuncionarioController cf = new CadastroFuncionarioController();
        cf.removerFuncionario(tfCPF.getText());
        lbValidacao.setText("FUNCIONARIO REMOVIDO COM SUCESSO!");
        tfNome.setText("");
        tfCPF.setText("");
        btRemover.setDisable(true);
    }

    @FXML
    void voltar() {
        tfNome.clear();
        tfCPF.clear();
        btRemover.setDisable(true);
        projetoPOO.trocaTela("gerenciadorFuncionario");

    }

}
