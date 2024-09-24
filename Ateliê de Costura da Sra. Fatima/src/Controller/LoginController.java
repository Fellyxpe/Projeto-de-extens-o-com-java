/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import view.Login;
import view.MenuPrincipal;

/**
 *
 * @author darkm
 */
public class LoginController {
    
    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view){
        this.view = view;
        this.helper = new LoginHelper(view);
        
    }
    
    
    public void entrarNoSistema () {
        
    //pegar usuario da view
    Usuario usuario = helper.obterModelo();
    //pesquisar usuario no banco
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
    //se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco direcionar para menu principal
    if(usuarioAutenticado != null){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.view.dispose();
    }else{//senão mostrar uma mensagem ao usuario "usuario ou senha invalidos"
        view.exibeMensagem("Usuario ou senha invalidos");
    }
    
    }
    
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("executei o fiz tarefa");
    }
    
}
