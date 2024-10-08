/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.ImageIcon;
import Controller.menuPrincipalController;
        
        

/**
 *
 * @author darkm
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private final menuPrincipalController controller;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.controller = new menuPrincipalController(this);
    }
private void jLabel1 () {
    ImageIcon icon;
        icon = new ImageIcon("src/view.imagens/fundo tela principal.jpg");
    icon.setImage (icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), 1));
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        clienteAtual = new javax.swing.JMenuItem();
        servico = new javax.swing.JMenuItem();
        trocaUsuario = new javax.swing.JMenuItem();
        jMenuOperacao = new javax.swing.JMenu();
        agenda = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        relatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/tela de fundo 2.png"))); // NOI18N

        jMenuCadastro.setText("Cadastro");
        jMenuCadastro.setMinimumSize(new java.awt.Dimension(32, 22));

        clienteAtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icons/cliente.png"))); // NOI18N
        clienteAtual.setText("Cliente");
        jMenuCadastro.add(clienteAtual);

        servico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icons/tesoura.png"))); // NOI18N
        servico.setText("Serviço");
        jMenuCadastro.add(servico);

        trocaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icons/trocarusuario.png"))); // NOI18N
        trocaUsuario.setText("Usuario");
        jMenuCadastro.add(trocaUsuario);

        jMenuBar1.add(jMenuCadastro);

        jMenuOperacao.setText("Operação");

        agenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icons/agenda.png"))); // NOI18N
        agenda.setText("Agenda");
        agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaActionPerformed(evt);
            }
        });
        jMenuOperacao.add(agenda);

        jMenuBar1.add(jMenuOperacao);

        jMenuRelatorio.setText("Relatório");

        relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icons/agenda-2.png"))); // NOI18N
        relatorio.setText("Gerar Relatório");
        jMenuRelatorio.add(relatorio);

        jMenuBar1.add(jMenuRelatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendaActionPerformed
        this.controller.navegarParaAgenda();        // TODO add your handling code here:
    }//GEN-LAST:event_agendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agenda;
    private javax.swing.JMenuItem clienteAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuOperacao;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenuItem relatorio;
    private javax.swing.JMenuItem servico;
    private javax.swing.JMenuItem trocaUsuario;
    // End of variables declaration//GEN-END:variables
}
