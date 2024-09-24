/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import view.Agenda;

/**
 *
 * @author darkm
 */
public class AgendaHelper implements IHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTabela().getModel();
        tableModel.setNumRows(0);
        
        //Preencher a lista preenchendo o table model
        
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
            
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
            
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente ().getModel(); 
        
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        
        for (Servico servico : servicos){
            comboBoxModel.addElement(servico);
        }
    }

    public Cliente obterCliente() {
        return (Cliente)view.getjComboBoxCliente().getSelectedItem();
    }
    
    public Servico obterServico() {
        return (Servico)view.getjComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getjTextValor().setText(valor + "");
    }

    @Override
    public Agendamento obterModelo() {
        try {
        int id = Integer.parseInt(view.getjTextId().getText());
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        float valor = Float.parseFloat(view.getjTextValor().getText());
        
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String dataHora = data + " " + hora;
        
        String observacao = view.getjTextObservacao().getText();
        
        if (cliente == null || servico == null) {
            throw new IllegalArgumentException("Cliente ou serviço não selecionado!");
        }
        
        return new Agendamento(id, cliente, servico, (int) valor, dataHora, observacao);
        } catch (NumberFormatException e) {
        return null;
        }
    }

    @Override
    public void limparTela() {
        view.getjTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getjTextObservacao().setText("");
    }
}