/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agendamento {
    
    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private LocalDateTime dataHora;        
    private String observacao;

    private static final Logger LOGGER = Logger.getLogger(Agendamento.class.getName());

     // Construtor com observação
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, LocalDateTime dataHora, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.dataHora = dataHora; // Corrigido: usando o parâmetro dataHora
        this.observacao = observacao; // Corrigido: atribuindo a observação corretamente
    }

    // Construtor sem observação
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, LocalDateTime dataHora) {
        this(id, cliente, servico, valor, dataHora, ""); // Chamando o construtor principal com observação vazia
    }

    
    
    // Getters e setters
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.dataHora.format(formatter);
    }

    public String getHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return this.dataHora.format(formatter);
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}