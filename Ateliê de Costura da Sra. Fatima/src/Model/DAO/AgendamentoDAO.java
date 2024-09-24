/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Agendamento;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class AgendamentoDAO {
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param agendamento exige que seja passado um objeto do tipo agendamento
     */
    public void insert(Agendamento agendamento){
          
        if(agendamento.getId() == 0){
            agendamento.setId(proximoId());
            Banco.agendamento.add(agendamento);
        }
        
        
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param agendamento
     * @return 
     */
    public boolean update(Agendamento agendamento){
        
        for (int i = 0; i < Banco.agendamento.size(); i++) {
            if(idSaoIguais(Banco.agendamento.get(i),agendamento)){
                Banco.agendamento.set(i, agendamento);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param agendamento
     * @return 
     */
    public boolean delete(Agendamento agendamento){
        for (Agendamento agendamentoLista : Banco.agendamento) {
            if(idSaoIguais(agendamentoLista,agendamento)){
                Banco.agendamento.remove(agendamentoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Agendamento> selectAll(){
        return Banco.agendamento;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param agendamento
     * @param agendamentoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Agendamento agendamento, Agendamento agendamentoAComparar) {
        return agendamento.getId() ==  agendamentoAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Agendamento agendamento : Banco.agendamento) {           
           int id = agendamento.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }
    
}
