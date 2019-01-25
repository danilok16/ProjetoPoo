package com.projetopoo.view;

import com.projetopoo.controler.FornecedorController;
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroFornecedorControllerView {
    @FXML 
    private Button btCadastrarFornecedor;
    @FXML 
    private Button btCancelar;
    @FXML 
    private TextField tfCNPJ;
    @FXML 
    private TextField tfRazaoS;

    @FXML
    public void voltarTelaMenu() {
        projetoPOO.trocaTela("menuFornecedor");
    }
    @FXML
    public void cadastrarFornecedor(){
        // Codigo que Bruno fez
        if(tfCNPJ.getText() != null && tfRazaoS.getText() != null){
            ArrayList<FornecedorModel> c = FornecedorController.restaurarFornecedor();// c eh o array de fornecedor
            FornecedorModel novoForn = new FornecedorModel(tfCNPJ.getText(), Integer.parseInt(tfRazaoS.getText()), FornecedorController.GeraIdFornecedor());
            if(c.contains(novoForn)){
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Não é possível realiza esta operação");
                dialogoInfo.setContentText("O fornecedor do cnpj: "+tfCNPJ+"  já foi cadastrado!");
                dialogoInfo.showAndWait();
            }else{
                FornecedorController.inserirFornecedor(novoForn);
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Não é possível realiza esta operação");
                dialogoInfo.setContentText("O fornecedor do cnpj: "+tfCNPJ+"  já foi cadastrado!");
                dialogoInfo.showAndWait();
            }
            tfCNPJ.setText("");
            tfRazaoS.setText("");
            projetoPOO.trocaTela("menuFornecedor");
        }  
    }   
}
    