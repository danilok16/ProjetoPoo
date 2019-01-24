/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import com.projetopoo.controler.ItemController;
import com.projetopoo.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeItemListarControllerView implements Initializable {

     @FXML
    private Button btListar;

    @FXML
    private TextField tfListar;
    
    @FXML
    private Button btVoltar;
    
@FXML
   private TableView<ProdutoModel> tableViewItens;

    @FXML
    private TableColumn<ProdutoModel, String> tableColumnDescricao;
    
    
    @FXML
    private TableColumn<ProdutoModel, String> tableColumnId;

    @FXML
    private TableColumn<ProdutoModel, String> tableColumnQuantidade;

    @FXML
    private TableColumn<ProdutoModel, String> tableColumnPreco;

    @FXML
    private TableColumn<ProdutoModel, String> tableColumnValidade;
    
     @FXML
    private TableColumn<ProdutoModel, String> tableColumnIdFornecedor;

    @FXML
    private TableColumn<ProdutoModel, String> tableColumnPosicao;
    
  @FXML
    private RadioButton rdId;

    @FXML
    private RadioButton rdDescricao;

    @FXML
    private RadioButton rdPosicao;

    @FXML
    private RadioButton rdFonecedor;
    
     @FXML
     private ToggleGroup categoria;
   

    
    ArrayList<ProdutoModel> list = new ArrayList<>();
    private ObservableList<ProdutoModel> ObservableListItens;
    ItemController itemController = new ItemController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tfListar.setEditable(false);
          tableViewItens.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)  -> selecionarItemTableViewItens(newValue));
    }    
    
    public void alterarTextField(){
         RadioButton radio  = (RadioButton) categoria.getSelectedToggle();
         tfListar.setPromptText(radio.getText());
          if(radio.isDisabled() == false){
            tfListar.setEditable(true);
        }
    }
    public void listar(){
        RadioButton radio  = (RadioButton) categoria.getSelectedToggle();
        if(tfListar.getText() != null){
        list = itemController.recuperarListaEspecifica(tfListar.getText(), radio.getText());
      carregarTableViewItens(list);
      list.clear();
        }
    }
    
      public void carregarTableViewItens(ArrayList<ProdutoModel> listp){
          
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));
         tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        tableColumnPosicao.setCellValueFactory(new PropertyValueFactory<>("posicaoEstoque"));
       ObservableListItens = FXCollections.observableArrayList(listp);
        tableViewItens.setItems(ObservableListItens);
    }
   public void selecionarItemTableViewItens(ProdutoModel item){
    }
   
     public void backToMenuItem(){
    MainItem.trocaTela("itemMenu");
         
    }
   
}
