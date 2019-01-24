package com.projetopoo.view.forncedorview;

import com.projetopoo.controler.FornecedorController;
import com.projetopoo.model.FornecedorModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ConsultarFornecedorControllerView {

    @FXML
    private TextField tfId;

    @FXML
    public void voltarTelaMenu() {
        tfId.setText("");
        MainFornecedor.trocaTela("menuFornecedor");
    }
    
    @FXML 
    public void consultarFornecedor(){
        if(tfId.getText() != null){ //Precisa alterar a validação de entrada vazia, só isso não funciona
            FornecedorModel consulta = FornecedorController.ConsultaFornecedor(tfId.getText());
            
            if(consulta != null){
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setHeaderText("CNPJ: " + consulta.getCnpj() + "\nRazão Social: " + consulta.getRazaoSocial());
                dialogoInfo.showAndWait();
            }
            else{
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("O fornecedor não foi encontrado no sitema!");
                dialogoInfo.showAndWait();
            }
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Por favor preencha todas as informações!");
                dialogoInfo.showAndWait();
        }
        tfId.setText("");
    }
    
    
}
