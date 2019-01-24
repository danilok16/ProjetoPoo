/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.RequisicaoModel;
import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Túlio
 */
public class AlterarRequisicaoControllerView implements Initializable {
    
    @FXML
    private Button btConcluir;

    @FXML
    private Button btRemover;

    @FXML
    private TableView<RequisicaoModel> tbRequisicao;

    @FXML
    private TableColumn<String, RequisicaoModel> tcNome;

    @FXML
    private TableColumn<String, RequisicaoModel> tcQtd;
    
    @FXML
    private TableColumn<String, RequisicaoModel> tcStatus;

    @FXML
    private TableColumn<String, RequisicaoModel> tcDataDeEntrega;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField tfQtd;

    @FXML
    private DatePicker dpDataDeEntrega;
    
    ArrayList<RequisicaoModel> requisicaoList;
    RequisicaoModel requisicao;
    private ObservableList<RequisicaoModel> observableListTableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recuperarLista();
        carregarTableView();
        tbRequisicao.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) 
                -> selecionarTableView(newValue));
    }    
    
    public void recuperarLista(){
        RequisicaoController controller = new RequisicaoController();
        requisicaoList = controller.recuperar();
    }
    
    
    public void alterarData(){
       requisicao = tbRequisicao.getSelectionModel().getSelectedItem();
        int tam = requisicaoList.size(), i;
        if(dpDataDeEntrega.getValue().toString() != null){
            for(i = 0; i < tam; i++){
                if(requisicaoList.get(i) == requisicao){
                    String data = dpDataDeEntrega.getValue().toString();
                    requisicaoList.get(i).setDataDeEntrega(data);
                }
            }
        }
        carregarTableView();
    }
    
    public void alterarQtdDesejada(){
        requisicao = tbRequisicao.getSelectionModel().getSelectedItem();
        int tam = requisicaoList.size(), i;
        if(tfQtd.getText() != null){
            for(i = 0; i < tam; i++){
                if(requisicaoList.get(i) == requisicao){
                    requisicaoList.get(i).setQtdDesejada(Integer.parseInt(tfQtd.getText()));
                    tfQtd.setText("");
                }
            }
        }
        carregarTableView();
    }
    
    public void selecionarTableView(RequisicaoModel Requisicao){
        
    }
    
    public void carregarTableView(){
        ArrayList<RequisicaoModel> listaAuxiliar = new ArrayList<>();
        int tam = requisicaoList.size();
        for(int i = 0; i < tam; i++){
            if(requisicaoList.get(i).getStatus() == 1){
                listaAuxiliar.add(requisicaoList.get(i));
            }
        }
        observableListTableView = FXCollections.observableArrayList(listaAuxiliar);
        tbRequisicao.setItems(observableListTableView);
        tcNome.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tcQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tcDataDeEntrega.setCellValueFactory(new PropertyValueFactory<>("DataDeEntrega"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }
    
    
    public void removerRequisicao(){
        RequisicaoModel removerRequisicao = tbRequisicao.getSelectionModel().getSelectedItem();
        int indice;
        tbRequisicao.getItems().remove(removerRequisicao);
        indice = requisicaoList.indexOf(removerRequisicao); //indexOf retorna o indice em que ocorre o objeto
        removerRequisicao.setStatus(0); //Seta o status da requisição pra false
        requisicaoList.add(indice, removerRequisicao); //Altera
    }
    

      public void btCancelar(){
        tfQtd.setText("");
        projetoPOO.trocaTela("estoqueMenu");
        observableListTableView.clear();
    }
    public void btConcluir(){
        RequisicaoController controller = new RequisicaoController();
        controller.atualizarLista(requisicaoList);
    }    
}
