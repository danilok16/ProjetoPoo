package com.projetopoo.view;

import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.model.FuncionarioModel;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class AlterarFuncionarioControllerView {

  
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
    private Button btBuscar;
    @FXML
    private Label lbValidacao;
    @FXML
    private Label lbSucesso;

    
    public void BuscarFuncionario() throws IOException{
        FuncionarioModel f;
        CadastroFuncionarioController cf = new CadastroFuncionarioController();
        f= cf.ConsultaFuncionario(tfCPF.getText());
        lbSucesso.setText("");
        if(f==null){
            lbValidacao.setText("NÃO ENCONTRADO!");            
            
        }
        else{
            tfNome.setText(f.getNome());
            tfTelefone.setText(f.getCpf());
            tfFuncao.setText(f.getFuncao());
            tfSalario.setText(String.valueOf(f.getSalario()));
            btAlterar.setDisable(false);
            tfCPF.setDisable(true);
            tfNome.setDisable(false);
            tfTelefone.setDisable(false);
            tfFuncao.setDisable(false);
            tfSalario.setDisable(false);
            
        }
        
        
    
    }
    public void alterar(){
        FuncionarioModel f;
        CadastroFuncionarioController cf = new CadastroFuncionarioController();
        f= cf.ConsultaFuncionario(tfCPF.getText());
        f.setFuncao(tfFuncao.getText());
        f.setNome(tfNome.getText());
        f.setTel(tfTelefone.getText());
        f.setSalario(Float.parseFloat(tfSalario.getText()));
        cf.alterarFuncionario(f);
        tfCPF.setDisable(false);
        tfNome.setDisable(true);
        tfTelefone.setDisable(true);
        tfFuncao.setDisable(true);
        tfSalario.setDisable(true);
        tfFuncao.clear();
        tfNome.clear();
        tfCPF.clear();
        tfTelefone.clear();
        tfSalario.clear();
        lbSucesso.setText("ALTERADO COM SUCESSO!");
        
    }
    public void voltar(){
        tfFuncao.clear();
        tfNome.clear();
        tfCPF.clear();
        tfTelefone.clear();
        tfSalario.clear();
        btAlterar.setDisable(true);
        tfCPF.setDisable(false);
        lbValidacao.setText("");
        lbSucesso.setText("");
        
        projetoPOO.trocaTela("gerenciadorFuncionario");
    }
}
