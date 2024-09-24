/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    tableModel.setNumRows(0); // Limpa a tabela antes de preencher

    // Preencher a tabela com os agendamentos
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
        // Obtém os valores dos campos de texto e dos componentes
        int id = Integer.parseInt(view.getjTextId().getText());
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        float valor = Float.parseFloat(view.getjTextValor().getText());
        
        // Inicializa a variável fora do bloco try-catch
        LocalDateTime dataHora = null;

        try {
            // Verifica se os campos de data e hora não estão vazios
            String dataTexto = view.getDataFormatada().getText().trim();
            String horaTexto = view.getHoraFormatada().getText().trim();

            
            if (dataTexto.isEmpty() || horaTexto.isEmpty()) {
                throw new IllegalArgumentException("Os campos de data e hora não podem estar vazios.");
            }

            // Concatena data e hora com um espaço
            String dataHoraTexto = dataTexto + " " + horaTexto;

            // Define o padrão esperado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            // Faz o parse para LocalDateTime usando o formato definido
            dataHora = LocalDateTime.parse(dataHoraTexto, formatter);
            
            // Se chegar aqui, significa que o parsing foi bem-sucedido
            System.out.println("Data e hora válidas: " + dataHora);
            
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao converter data e hora: " + e.getMessage());
            return null; // Retorna null indicando erro
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento: " + e.getMessage());
            return null; // Retorna null indicando erro
        }
        
        // Obtém a observação
        String observacao = view.getjTextObservacao().getText();

        // Verifica se o cliente ou o serviço estão nulos
        if (cliente == null || servico == null) {
            System.out.println("Cliente ou serviço não selecionado.");
            return null; // Retorna null indicando erro
        }

        // Retorna um novo agendamento com todos os dados
        return new Agendamento(id, cliente, servico, valor, dataHora, observacao);
    } catch (NumberFormatException e) {
        System.out.println("Erro de número: " + e.getMessage());
        return null; // Retorna null indicando erro
    }
}

    @Override
    public void limparTela() {
        view.getjTextId().setText("0");
        view.getDataFormatada().setText("");
        view.getHoraFormatada().setText("");
        view.getjTextObservacao().setText("");
    }
}