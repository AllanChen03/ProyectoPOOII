/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Ventana extends javax.swing.JFrame {
    ArrayList<Ficha> fichas;
    ArrayList<Ficha> fichasJuego;
    ArrayList<Jugador> jugadores;
    Tablero tableroJuego;
    String[] colores = {"Amarillo", "Rojo", "Azul", "Negro"};
    Ficha fichaSeleccionada = null;
    String casillaSeleccionada = null;
    int numeroMazo = 104;
    JLabel numeroMazoLabel;
    int contador = 0;
    
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        fichas = new ArrayList<Ficha>();
        fichasJuego = new ArrayList<Ficha>();
        jugadores = new ArrayList<Jugador>();
        initComponents();
        tableroJuego = new Tablero();
        crearFichas();
        casillasJuego();
        iniciarJuego();
        numeroMazoLabel = new JLabel("Cartas: 104");
        numeroMazoLabel.setBounds(1240,900,150,150);
        numeroMazoLabel.setForeground(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN, 24);
        numeroMazoLabel.setFont(font);
        pnlPrincipal.add(numeroMazoLabel);
    }
    
    public void iniciarJuego(){
        Jugador jugador = new Jugador("Allan");
        Jugador jugador2 = new Jugador("Li Hao");
        Jugador jugador3 = new Jugador("Diana");
        Jugador jugador4 = new Jugador("Maria");
        jugadores.add(jugador);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        //for (Jugador player : jugadores){
        for (int j = 0; j < 14; j++) {
            Ficha ficha = fichasJuego.get(0);
            fichasJuego.remove(ficha);
            pnlPrincipal.add(ficha.getLabel());
            ficha.getLabel().setSize(50, 50);
            //player.tomarFicha(ficha);
            /*System.out.println(player.getNombre());
            if(player.getNombre().equals("Allan")){*/
            if (contador < 10){
                ficha.getLabel().setLocation(530+j*50,850);
            } else{
                ficha.getLabel().setLocation(530+((j-10)*50),900);
            }
            contador +=1;
            for (Ficha fichax :fichasJuego){
                System.out.println(fichax);
            }
               
        }
        
    
    
        //}
        
        
        
        
    }
    
    public void casillasJuego(){
        String path = "C:\\Users\\User\\Documents\\Universidad\\II Semestre 2023\\"
                + "Introclases23II\\Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2\\img\\";
        
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel casilla = new JLabel("casillaVacia");
                casilla.setIcon(new ImageIcon(path + "casilla.png"));
                pnlPrincipal.add(casilla);
                casilla.setSize(50,50);
                casilla.setLocation((j*50)+225,(i*60)+200);
            }
            
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel casilla = new JLabel("casillaVacia");
                casilla.setIcon(new ImageIcon(path + "casilla.png"));
                pnlPrincipal.add(casilla);
                casilla.setSize(50,50);
                casilla.setLocation((j*50)+475,(i*60)+200);
            }
            
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 13; j++) {
                JLabel casilla = new JLabel("casillaVacia");
                casilla.setIcon(new ImageIcon(path + "casilla.png"));
                pnlPrincipal.add(casilla);
                casilla.setSize(50,50);
                casilla.setLocation((j*50)+725,(i*60)+200);
            }
            
        }
        tableroJuego.imprimirTablero();
        JLabel mazo = new JLabel("mazo");
        mazo.setIcon(new ImageIcon(path + "cartaMas.png"));
        pnlPrincipal.add(mazo);
        mazo.setSize(100,148);
        mazo.setLocation(1250,800);
        mazo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Tomar ficha");
                        actualizarMazo();
                    }
                });
        
    }
    
    public void actualizarMazo(){
        numeroMazo -= 1;
        numeroMazoLabel.setText("Cartas: " + Integer.toString(numeroMazo));
       
    }
    
    public void crearFichas(){
        String path = "C:\\Users\\User\\Documents\\Universidad\\II Semestre 2023\\"
                + "Introclases23II\\Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2\\img\\";
        int contador = 0;
        for (String color : colores) {
            for (int i = 1; i <= 13; i++) {
                for (int j = 0; j < 2; j++) {
                    JLabel label = new JLabel(Integer.toString(i) +  " " + Integer.toString(j) + color);
                    label.setName(Integer.toString(i) +  " " + Integer.toString(j) + color);
                    fichas.add(new Ficha(i, color, label));
                    fichasJuego.add(new Ficha(i, color, label));
                    if (color.equals("Amarillo")){
                        label.setIcon(new ImageIcon(path + Integer.toString(i) + "amarillo.png"));
                    } else if(color.equals("Rojo")){
                        label.setIcon(new ImageIcon(path + Integer.toString(i) + "rojo.png"));
                    } else if(color.equals("Azul")){
                        label.setIcon(new ImageIcon(path + Integer.toString(i) + "azul.png"));
                    } else if(color.equals("Negro")){
                        label.setIcon(new ImageIcon(path + Integer.toString(i) + "negro.png"));
                    }
                    
                }
              
                /*pnlPrincipal.add(label);
                label.setSize(50, 50); 
                label.setLocation(i*50,contador*50);
               
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        for (Ficha ficha : fichas){
                            if(ficha.getLabel().getText().equals(label.getText())){
                                fichaSeleccionada = ficha;
                            }
                        }
                    }
                });
                */
            }
            contador += 1;
            Collections.shuffle(fichasJuego);
        
        }
                
        for (Ficha ficha :fichasJuego){
            System.out.println(ficha);
        }
        
        /*JLabel tablero = new JLabel("tablero");
        tablero.setIcon(new ImageIcon(path + "tablero.png"));
        pnlPrincipal.add(tablero);
        tablero.setSize(540,130);
        tablero.setLocation(530,850);*/
    }
    
    private void colocarFicha() {
        String path = "C:\\Users\\User\\Documents\\Universidad\\II Semestre 2023\\"
                + "Introclases23II\\Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2\\img\\";
        if (casillaSeleccionada != null && fichaSeleccionada != null) {
            
            
            fichas.remove(fichaSeleccionada);
            pnlPrincipal.remove(fichaSeleccionada.getLabel());
            pnlPrincipal.repaint(); // Para que se repinte la ventana
        } else {
            System.out.println("Selecciona una ficha y una casilla vacía antes de colocar la ficha.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaChat = new javax.swing.JTextArea();
        chatText = new javax.swing.JTextField();
        enviarMensaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(32, 65, 116));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtAreaChat.setColumns(20);
        txtAreaChat.setRows(5);
        jScrollPane1.setViewportView(txtAreaChat);

        chatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatTextActionPerformed(evt);
            }
        });

        enviarMensaje.setText("Enviar");
        enviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarMensajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chatText)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1164, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(37, 37, 37))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enviarMensaje)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(858, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enviarMensaje))
                        .addGap(13, 13, 13))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 532, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path = "C:\\Users\\User\\Documents\\Universidad\\II Semestre 2023\\"
        + "Introclases23II\\Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2\\img\\";

        JLabel label = new JLabel("1rojo");
        label.setIcon(new ImageIcon(path + "1rojo.png"));
        pnlPrincipal.add(label);
        pnlPrincipal.setComponentZOrder(label, 0);
        label.setSize(50,50);
        label.setLocation(300,600);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chatTextActionPerformed

    private void enviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarMensajeActionPerformed
        String mensaje = chatText.getText();
        if (mensaje.isEmpty() || mensaje.equals("Escribe un mensaje")){
            chatText.setText("Escribe un mensaje");
        }
       
        else{  
            txtAreaChat.append(mensaje);
            txtAreaChat.append("\n");
            chatText.setText("");
        }
    }//GEN-LAST:event_enviarMensajeActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chatText;
    private javax.swing.JButton enviarMensaje;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextArea txtAreaChat;
    // End of variables declaration//GEN-END:variables
}
