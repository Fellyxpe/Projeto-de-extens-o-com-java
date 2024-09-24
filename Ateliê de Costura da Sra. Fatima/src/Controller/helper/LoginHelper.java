/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.helper;

import Model.Usuario;
import view.Login;
/**
 *
 * @author darkm
 */
public class LoginHelper implements IHelper {
    
    private final Login view;
    
    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
    String nome = view.getTextUsuario().getText();
    char[] senhaCharArray = view.getTextSenha().getPassword();
    String senha = new String(senhaCharArray); // Convertendo char[] para String
    
    Usuario modelo = new Usuario(0, nome, senha);
    return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    public void limparTela() {
        view.getTextUsuario(). setText(" ");
        view.getTextSenha().setText(" ");
        
    }
}
