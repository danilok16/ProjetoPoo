package com.projetopoo.controler;
import com.projetopoo.factory.FornecedorFactory;
import com.projetopoo.interfaces.Fornecedor_dao;
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;

public class FornecedorController { 
    public static ArrayList<FornecedorModel> restaurarFornecedor(){
        ArrayList<FornecedorModel> c;// c eh o array de fornecedor
        Fornecedor_dao fd = FornecedorFactory.create();//cd onde está chamando os metodos do DAO
        c = fd.recuperar();
        return c;
    }
    
    public static boolean removerFornecedor(String idString){
        int tamanho, id = Integer.parseInt(idString);
        Fornecedor_dao dao = FornecedorFactory.create();
        FornecedorModel fornecedor;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                fornecedor = lista.get(i);                
                if(id == fornecedor.getIdForn()){
                    lista.remove(i);
                    dao.alterar(lista);
                    return true;
                }
            }
        } 
        return false;
    }
    
    public static int inserirFornecedor (FornecedorModel fornecedor){
        Fornecedor_dao fd = FornecedorFactory.create();
        fornecedor.setIdForn(Integer.parseInt(GeraIdFornecedor()));
        fd.salvar(fornecedor);
        return fornecedor.getIdForn();
    
    }
    
    public static String GeraIdFornecedor(){
        int novoId= 0;
        FornecedorModel ultimo;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
              
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(Integer.toString(ultimo.getIdForn()));
            novoId = i +1;
        }
        String t = String.valueOf(novoId);
        return t;
    }
    
    public static FornecedorModel ConsultaFornecedor(String idString){
        int tamanho, id = Integer.parseInt(idString);
        FornecedorModel fornecedor;
        ArrayList<FornecedorModel> lista;
        lista= restaurarFornecedor();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){
                fornecedor =lista.get(i);                
                if(id == fornecedor.getIdForn()){
                    return lista.get(i);
                }
            }
        }
        return null;
    }
    
    public static boolean alterarFornecedor(FornecedorModel fornecedor){
        int tamanho;
        ArrayList<FornecedorModel> lista;
        lista= restaurarFornecedor();
       Fornecedor_dao dao = FornecedorFactory.create();
        tamanho = lista.size();
        if(!lista.isEmpty()){
            for(int i = 0; i<tamanho;i++){              
                if(fornecedor.getIdForn() == lista.get(i).getIdForn()){
                    lista.get(i).setCnpj(fornecedor.getCnpj());
                    lista.get(i).setRazaoSocial(fornecedor.getRazaoSocial());
                    dao.alterar(lista);
                    return true;
                }
            }
        }
        return false;
    }
    
    /*private static ArrayList<FornecedorModel> fornecedorList = new ArrayList();     
    public static void recuperarLista(){
        FornecedorDAO dao = new FornecedorDAO();
        fornecedorList = dao.recuperar();
    }
    
    public static boolean buscar(String cnpj){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
               return true;
            }
        }
        return false;
    }
    
    public static boolean inserir(String cnpj, int idForn, String razao){
        FornecedorModel novo = new FornecedorModel(cnpj, idForn, razao);
        if(buscar(cnpj)){
            return false;
        }
        else{
        FornecedorDAO save = new FornecedorDAO();
        save.inserir(novo);
        return true;
        }
    }
    
    public boolean remover(String cnpj){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
                fornecedorList.remove(i);
                FornecedorDAO remove = new FornecedorDAO();
                remove.salvarAlteracao(fornecedorList);
            }
        }
        return false;
    }
    
    public void listar(){
        for(int i = 0; i <= fornecedorList.size(); i++){
            System.out.println(fornecedorList.get(i).toString());
        }
    }
    
    public boolean alterar(String cnpj, String novoCnpj, String novaRazao){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
                fornecedorList.get(i).setCnpj(novoCnpj);
                fornecedorList.get(i).setCnpj(novaRazao);
                return true;
            }
        }
        return false;
    }
    
    public void exibir(String cnpj){
        for(int i=0; i <= fornecedorList.size(); i++){
            if(fornecedorList.get(i).getCnpj().equals(cnpj)){
               System.out.println(fornecedorList.get(i).toString());
            }
        }
    }*/
}