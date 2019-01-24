package com.projetopoo.view;

import com.projetopoo.command.*;
import com.projetopoo.controler.CompraController;
import com.projetopoo.model.CompraModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaTrocoControllerView implements Initializable{

    @FXML
    private Button btConcluir;

    @FXML
    private Button btCancelar;

    @FXML
    private ComboBox<String> cbPagamento;

    @FXML
    private Label lbPagamento;

    @FXML
    private TextField tfPagamento;
    
    private ObservableList<String> obervableListPagamento;
    private final ArrayList<String> formasDePagamento = new ArrayList();
    private String fPagamento;
    CompraModel compra = CompraController.getUltimaCompra();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboBoxPagamento();
    }
    
    @FXML
    void carregarComboBoxPagamento(){
        formasDePagamento.add("Dinheiro");
        formasDePagamento.add("Cartão de Crédito");
        formasDePagamento.add("Cartão de Débito");
        obervableListPagamento = FXCollections.observableArrayList(formasDePagamento);
        cbPagamento.setItems(obervableListPagamento);
    }
    
    @FXML
    public void pegaFormaDePagamento(){
        if(cbPagamento.getSelectionModel().getSelectedItem() != null){
            fPagamento = cbPagamento.getSelectionModel().getSelectedItem();
        }
        preencheLabelPagamento();
    }
    
    @FXML
    public void preencheLabelPagamento(){
        if("Dinheiro".equals(fPagamento)){
            lbPagamento.setText("Valor pago: ");
        }
        else if("Cartão de Débito".equals(fPagamento)){
            lbPagamento.setText("Informe a senha: ");
        }
        else if("Cartão de Débito".equals(fPagamento)){
            lbPagamento.setText("Informe a senha: ");
        }
    }
    
    @FXML
    public void processaPagamento(){
        float total = compra.getValorTot(), valorPago, troco, qtdParcelas, valorParcelas;
        String entradaTF;
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        
        if("Dinheiro".equals(fPagamento)){
            entradaTF = tfPagamento.getText();
            if(!"".equals(entradaTF)){
                valorPago = Float.parseFloat(entradaTF);
                if(valorPago < total){
                    dialogoInfo.setTitle("AVISO");
                    dialogoInfo.setHeaderText("Valor inferior ao total!");
                    dialogoInfo.showAndWait();
                }
                else{
                    if(valorPago > total){
                    troco = valorPago - total;
                    dialogoInfo.setTitle("AVISO");
                    dialogoInfo.setHeaderText("Conta paga!");
                    dialogoInfo.setHeaderText("Troco: " + troco);
                    dialogoInfo.showAndWait();
                    }
                    else{
                    dialogoInfo.setTitle("AVISO");
                    dialogoInfo.setHeaderText("Conta paga!");
                    dialogoInfo.showAndWait();
                    }
                    CompraController.pagarCompra(compra, new PagamentoDinheiro());
                }
            }
        }
        else if("Cartao de Credito".equals(fPagamento)){
            entradaTF = tfPagamento.getText();
            if(!"".equals(entradaTF)){
                qtdParcelas = Float.parseFloat(entradaTF);
                valorParcelas = total / qtdParcelas;
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Conta paga!");
                dialogoInfo.setHeaderText("Parcelas: " + qtdParcelas + " de R$" + valorParcelas);
                dialogoInfo.showAndWait();
                CompraController.pagarCompra(compra, new PagamentoCartaoCredito());
                
            }
        }
        
        else if("Cartao de Debito".equals(fPagamento)){
            entradaTF = tfPagamento.getText();
            if(!"".equals(entradaTF)){
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Conta paga!");
                dialogoInfo.showAndWait();
                CompraController.pagarCompra(compra, new PagamentoCartaoDebito());
            }
        }
    }
    
    @FXML
    void btCancelar(){
        lbPagamento.setText("");
        tfPagamento.setText("");
        projetoPOO.trocaTela("caixa");
    }
}
