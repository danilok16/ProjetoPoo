/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import static com.projetopoo.controler.FornecedorController.ConsultaFornecedor;
import com.projetopoo.controler.ItemController;
import com.projetopoo.model.FornecedorModel;
import com.projetopoo.model.ProdutoModel;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeItemAlterarControllerView implements Initializable {

 @FXML
    private Button btVoltar;

    @FXML
    private TextField tfIdFornecedor;

    @FXML
    private TextField tfIdItem;

    @FXML
    private TextField tfPosicao;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfDescricao;

    @FXML
    private DatePicker dpData;

    @FXML
    private TextField tfPreco;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btRemover;

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
    private TableColumn<ProdutoModel, String> tableColumnPosicao;
    
      @FXML
    private TableView<FornecedorModel> tableViewFornecedores;

    @FXML
    private TableColumn<FornecedorModel, String> tableColumnIdFornecedor;

    @FXML
    private TableColumn<FornecedorModel, String>  tableColumnRazaoSocial;

    @FXML
    private TableColumn<FornecedorModel, String>  tableColumnCnpj;

   @FXML
    private Label lblTitulo;
    
    @FXML
    private Button btRemoverFornecedor;
    
    
      ArrayList<ProdutoModel> list = new ArrayList<>();
    private ObservableList<ProdutoModel> ObservableListItens;
    ItemController itemController = new ItemController();
    
      ArrayList<FornecedorModel> listFornecedor = new ArrayList<>();
     private ObservableList<FornecedorModel> ObservableListFornecedores;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.list = itemController.recuperarLista();
       // ArrayList<FornecedorModel> fornecedores =   restaurarFornecedor();
      //  this.listFornecedor = fornecedores;
        carregarTableViewItens(this.list);
      //  carregarTableViewFornecedor(this.listFornecedor);
        tableViewItens.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue)  -> selecionarItemTableViewItens(newValue));
        
           tableViewFornecedores.getSelectionModel().selectedItemProperty().addListener(
         (observable, oldValue, newValue)  -> selecionarItemTableViewFornecedor(newValue));
    }    
    
     public void carregarTableViewItens(ArrayList<ProdutoModel> listp){
          tableViewItens.refresh();
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));
         tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        tableColumnPosicao.setCellValueFactory(new PropertyValueFactory<>("posicaoEstoque"));
       ObservableListItens = FXCollections.observableArrayList(listp);
        tableViewItens.setItems(ObservableListItens);
       
    }
    
    public void carregarTableViewFornecedor(ArrayList<FornecedorModel> listFornecedorp){
        
        tableColumnIdFornecedor.setCellValueFactory(new PropertyValueFactory<>("idForn"));
        tableColumnRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
         tableColumnCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
       ObservableListFornecedores = FXCollections.observableArrayList(listFornecedorp);
        tableViewFornecedores.setItems(ObservableListFornecedores);
       
    }
    
    public static final LocalDate LOCAL_DATE (String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }
    
    public void selecionarItemTableViewItens(ProdutoModel itemp){
        tfDescricao.setText(itemp.getDescricao());
        tfPreco.setText(Float.toString(itemp.getPreco()));
        dpData.setValue( LOCAL_DATE(itemp.getValidade()));
        tfQuantidade.setText(Integer.toString(itemp.getQtdEstoque()));
        tfPosicao.setText(itemp.getPosicaoEstoque());
        carregarTableViewFornecedor(itemp.getFornecedor());
    }
    
     public void selecionarItemTableViewFornecedor(FornecedorModel fornecedorp){
       // System.out.println(debitop.getDescricao());
    }
    
      public void salvarTableViewItens(){
      
            itemController.salvarAlteracao(list);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setHeaderText("SALVO COM SUCESSO");
            dialogoInfo.showAndWait();
        
    }
      
       public void alterarItemTableViewItemDescricao(){//altera se o usuario pressionar enter
      ProdutoModel item  = tableViewItens.getSelectionModel().getSelectedItem();
        for(int i =0; i < list.size(); i++){
             if(item.getIdItem().equals(list.get(i).getIdItem())){
               list.get(i).setDescricao(tfDescricao.getText());
             }
        }
        carregarTableViewItens(this.list);
    }
    public void alterarItemTableViewItemData(){//altera se o usuario pressionar enter
        ProdutoModel item  = tableViewItens.getSelectionModel().getSelectedItem();
        for(int i =0; i < list.size(); i++){
            if(item.getIdItem().equals(list.get(i).getIdItem())){
                list.get(i).setValidade(dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }
        carregarTableViewItens(this.list);
    }
    public void alterarItemTableViewItemPreco(){//altera se o usuario pressionar enter
        ProdutoModel item  = tableViewItens.getSelectionModel().getSelectedItem();
        for(int i =0; i < list.size(); i++){
             if(item.getIdItem().equals(list.get(i).getIdItem())){
                list.get(i).setPreco(Float.parseFloat(tfPreco.getText()));
             }
        }
        carregarTableViewItens(this.list);
    }
      
      public void alterarItemTableViewItemQuantidade(){//altera se o usuario pressionar enter
      ProdutoModel item  = tableViewItens.getSelectionModel().getSelectedItem();
        for(int i =0; i < list.size(); i++){
             if(item.getIdItem().equals(list.get(i).getIdItem())){
                list.get(i).setQtdEstoque(Integer.parseInt(tfQuantidade.getText()));
             }
        }
        carregarTableViewItens(this.list);
    }
      
       public void alterarItemTableViewItemPosicao(){//altera se o usuario pressionar enter
      ProdutoModel item  = tableViewItens.getSelectionModel().getSelectedItem();
        for(int i =0; i < list.size(); i++){
             if(item.getIdItem().equals(list.get(i).getIdItem())){
               list.get(i).setPosicaoEstoque(tfPosicao.getText());
             }
        }
        carregarTableViewItens(this.list);
    }
       public void alterarItemTableViewItemFornecedor(){//altera se o usuario pressionar enter
      ProdutoModel item  = tableViewItens.getSelectionModel().getSelectedItem();
        for(int i =0; i < list.size(); i++){
             if(item.getIdItem().equals(list.get(i).getIdItem())){
                  FornecedorModel  fornecedor  = ConsultaFornecedor(tfIdFornecedor.getText());
             if(fornecedor != null){
                 listFornecedor.add(fornecedor);
                 item.setFornecedor(listFornecedor);
               carregarTableViewFornecedor(this.listFornecedor);
     }
         else{
             Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
             dialogoInfo.setTitle("AVISO");
             dialogoInfo.setHeaderText("FORCEDOR NÃO CADASTRADO");
              dialogoInfo.showAndWait();
         }
             }
        }
       
        carregarTableViewItens(this.list);
    }
      
     
    public void removerItemTableViewItens(){
           ProdutoModel item = tableViewItens.getSelectionModel().getSelectedItem();
            tableViewItens.getItems().remove(item);
            this.list.remove(item);
              carregarTableViewItens(this.list);
    }
    
    

      public void backToMenuItem(){
        MainItem.trocaTela("itemMenu");
         
    }
    
}
