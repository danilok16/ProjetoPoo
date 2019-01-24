/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.FuncionarioModel;
import com.projetopoo.model.RequisicaoModel;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author dkaus
 */
public class AprovarRequisicaoControllerView implements Initializable  {
    
    
       @FXML
    private TableView<RequisicaoModel> tbViewRequisicoes;

    @FXML
    private TableColumn<RequisicaoModel, String> tbCRequisicao;

    @FXML
    private TextField tfQtd;

    @FXML
    private TextField tfDescricao;


    @FXML
    private TextField tfIdRequisitante;

    @FXML
    private TextField tfValorTotal;

    @FXML
    private TextField tfStatus;

    @FXML
    private TextField tfIdRequisicao;
    
     @FXML
    private TextField tfDataSolicitacao;

    @FXML
    private TextField tfDataEntrega;
    
     @FXML
    private TextField tfAprovador;

    @FXML
    private Button btAprovar;

    @FXML
    private Button btVoltar;

    
    ArrayList<RequisicaoModel> requisicaoList = new ArrayList<>();
    private ObservableList<RequisicaoModel> ObservableListRequisicoes;
    RequisicaoController c = new RequisicaoController();
    RequisicaoModel requisicao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       
       tbViewRequisicoes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)  -> selecionarItemTableViewItens(newValue));
       
    }
    
    
    public void requisicoes(){
      requisicaoList =  c.requisicoesPendentes(tfAprovador.getText());
      carregarTableViewRequisicoes(requisicaoList);
    }
      public void carregarTableViewRequisicoes(ArrayList<RequisicaoModel> listp){
          
       tbCRequisicao.setCellValueFactory(new PropertyValueFactory<>("idRequisicao"));
       ObservableListRequisicoes = FXCollections.observableArrayList(listp);
        tbViewRequisicoes.setItems(ObservableListRequisicoes);
    }
     
       public static final LocalDate LOCAL_DATE (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
         }
      
   public void selecionarItemTableViewItens(RequisicaoModel requisicao){
       tfDescricao.setText(requisicao.getDescricao());
       tfQtd.setText(String.valueOf(requisicao.getQtdDesejada()));
       tfValorTotal.setText(String.valueOf(requisicao.getValorTotal()));
       tfStatus.setText(String.valueOf(requisicao.getStatus()));
       tfIdRequisicao.setText(requisicao.getIdRequisicao());
       tfIdRequisitante.setText(requisicao.getRequisitante().getNome());
       tfDataEntrega.setText(requisicao.getDataDeEntrega());
       tfDataSolicitacao.setText(requisicao.getDataDeEmissao());
       this.requisicao = requisicao;
    }
    
   
   public void aprovarRequiscao(){
       CadastroFuncionarioController f = new CadastroFuncionarioController();
      FuncionarioModel aprovador = f.ConsultaFuncionario(tfAprovador.getText());
       requisicao.setAprovador(aprovador);
       c.Aprovar(this.requisicao);
      c.alterar(requisicao);
   }
   
     public void backToMenuRequisicao(){
     MainRequisicaoDeCompra.trocaTela("menuRequisicao");
         
    }
        
}
