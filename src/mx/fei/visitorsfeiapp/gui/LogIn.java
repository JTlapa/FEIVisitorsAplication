/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
/**
 *
 * @author chuch
 */
public class LogIn extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel title;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jtxtField1;
    private JTextField jtxtField2;
    
    public LogIn(){
        super("Visitas - FEI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(180,100,900,500);
        this.setLayout(null);
        this.setVisible(true);
        
        title = new JLabel();
        title.setFont(new Font("Dialog", 0, 30));
        title.setText("Inicio de sesion");
        title.setBounds(320, 10, 600, 35);
        this.add(title);

        jLabel1 = new JLabel("ID");
        jLabel1.setFont(new Font("Dialog", 0, 15));
        jLabel1.setBounds(250,150,100,30);
        this.add(jLabel1);
        
        jtxtField1 = new JTextField();
        jtxtField1.setBounds(320,150,200,30);
        this.add(jtxtField1);

        jLabel2 = new JLabel("Clave");
        jLabel2.setFont(new Font("Dialog", 0, 15));
        jLabel2.setBounds(250,210,100,30);
        this.add(jLabel2);
        
        jtxtField2 = new JTextField();
        jtxtField2.setBounds(320,210,200,30);
        this.add(jtxtField2);
        
        jButton1 = new JButton();
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(230, 320, 150, 50);
        this.add(jButton1);
        
        jButton2 = new javax.swing.JButton();
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(480, 320, 150, 50);
        this.add(jButton2);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
        new TableVisits();
    }                                        
    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.dispose();
    } 
}
