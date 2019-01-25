package com.projetopoo.view;

import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.model.FuncionarioModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ExibirFuncionarioControllerView {
    @FXML
    private Button btBuscar;
    @FXML
    private Button btAlterar;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCPF;
    @FXML
    private TextField tfFuncao;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfSalario;
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
        }
        else{
            tfNome.setText(f.getNome());
            tfTelefone.setText(f.getCpf());
            tfFuncao.setText(f.getFuncao());
            tfSalario.setText(String.valueOf(f.getSalario()));
            
        }
    }

    @FXML
    void limpar () {
       tfNome.clear();
       tfTelefone.clear();
       tfFuncao.clear();
       tfSalario.clear();
       tfCPF.clear();
    }

    @FXML
    void voltar() {
        limpar();
        projetoPOO.trocaTela("gerenciadorFuncionario");
    }

}
