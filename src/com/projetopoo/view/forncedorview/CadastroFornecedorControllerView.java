package com.projetopoo.view.forncedorview;

import com.projetopoo.controler.FornecedorController;
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadastroFornecedorControllerView {

    @FXML
    private TextField tfCNPJ;
    @FXML
    private TextField tfRazaoS;

    @FXML
    public void voltarTelaMenu() {
        MainFornecedor.trocaTela("menuFornecedor");
    }

    @FXML
    public void cadastrarFornecedor() {
        if (tfCNPJ.getText() != null && tfRazaoS.getText() != null) {  //Precisa alterar a validação de entrada vazia, só isso não funciona
            ArrayList<FornecedorModel> c = FornecedorController.restaurarFornecedor();// c eh o array de fornecedor
            FornecedorModel novoForn = new FornecedorModel(tfCNPJ.getText(), Integer.parseInt(FornecedorController.GeraIdFornecedor()), tfRazaoS.getText());
            if (c.contains(novoForn)) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Não é possível realiza esta operação");
                dialogoInfo.setContentText("O fornecedor do cnpj: " + tfCNPJ + "  já foi cadastrado!");
                dialogoInfo.showAndWait();
            } else {
                int id;
                id = FornecedorController.inserirFornecedor(novoForn);
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Fornecedor cadastrado com sucesso!");
                dialogoInfo.setContentText("ID do fornecedor: " + id);
                dialogoInfo.showAndWait();
            }
            MainFornecedor.trocaTela("menuFornecedor");
        } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("AVISO");
            dialogoInfo.setHeaderText("Por favor preencha todas as informações");
            dialogoInfo.showAndWait();
        }
        tfCNPJ.setText("");
        tfRazaoS.setText("");
    }
}
