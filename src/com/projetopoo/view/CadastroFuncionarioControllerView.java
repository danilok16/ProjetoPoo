package com.projetopoo.view;



import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.model.FuncionarioModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class CadastroFuncionarioControllerView {

    @FXML
    private Button btCadastrar;

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
    private PasswordField pfSenha;
    @FXML
    private Label lbValidacao;
    
    public void CadastroFuncionario(){
       lbValidacao.setText("");
         
        //float salario= Float.parseFloat(tfSalario.getText());
        CadastroFuncionarioController cf = new CadastroFuncionarioController();
        if(cf.ConsultaFuncionario(tfNome.getText())!= null){
            lbValidacao.setText("CPF JÁ CADASTRADO!");
        }
        else{
            FuncionarioModel f = new FuncionarioModel(tfFuncao.getText(),"00",Float.parseFloat(tfSalario.getText()),tfNome.getText(),tfTelefone.getText(),tfCPF.getText());
            cf.InserirFuncionario(f);
            lbValidacao.setText("CADASTRADO COM SUCESSO!!");
            tfFuncao.clear();
            tfNome.clear();
            tfCPF.clear();
            tfTelefone.clear();
            tfSalario.clear();
        }
    
    }
    public void limpa(){
        lbValidacao.setText("");
    }
    public void voltar(){
        tfFuncao.clear();
        tfNome.clear();
        tfCPF.clear();
        tfTelefone.clear();
        tfSalario.clear();
        lbValidacao.setText("");
 
        projetoPOO.trocaTela("gerenciadorFuncionario");
    }

}
