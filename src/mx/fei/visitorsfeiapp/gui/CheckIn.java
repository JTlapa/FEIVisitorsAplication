/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import mx.fei.visitorsfeiapp.logic.Visitor;
import mx.fei.visitorsfeiapp.logic.VisitsManager;
/**
 *
 * @author chuch
 */
public class CheckIn extends JFrame{
    private JButton jButton1;
    private JButton jButton2;
    private JLabel title;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jtxtField1;
    private JTextField jtxtField2;
    private JTextField jtxtField3;
    
    public CheckIn(){
        super("Visitas - FEI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(180,100,900,500);
        this.setLayout(null);
        this.setVisible(true);
        
        title = new JLabel();
        title.setFont(new Font("Dialog", 0, 30));
        title.setText("Registro de entrada");
        title.setBounds(320, 10, 600, 35);
        this.add(title);

        jLabel1 = new JLabel("Codigo de identificacion:");
        jLabel1.setFont(new Font("Dialog", 0, 15));
        jLabel1.setBounds(300,110,300,30);
        this.add(jLabel1);
        
        jtxtField1 = new JTextField();
        jtxtField1.setBounds(300,140,300,30);
        this.add(jtxtField1);
        
        jLabel2 = new JLabel("Asunto:");
        jLabel2.setFont(new Font("Dialog", 0, 15));
        jLabel2.setBounds(300,180,300,30);
        this.add(jLabel2);
        
        jtxtField2 = new JTextField();
        jtxtField2.setBounds(300,210,300,30);
        this.add(jtxtField2);
        
        jLabel3 = new JLabel("Persona a quien visita:");
        jLabel3.setFont(new Font("Dialog", 0, 15));
        jLabel3.setBounds(300,250,300,30);
        this.add(jLabel3);
        
        jtxtField3 = new JTextField();
        jtxtField3.setBounds(300,280,300,30);
        this.add(jtxtField3);
        
        jButton1 = new JButton();
        jButton1.setText("Registrar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(250, 340, 150, 50);
        this.add(jButton1);
        
        jButton2 = new javax.swing.JButton();
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(500, 340, 150, 50);
        this.add(jButton2);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        Visitor visitor = new Visitor();
        visitor.setId(jtxtField1.getText());
        visitor.setSubject(jtxtField2.getText());
        visitor.setVisiting(jtxtField3.getText());
        
        
        VisitsManager visits = new VisitsManager();
        if(visits.registerCheckIn(visitor) == 1) {
            jtxtField1.setText("");
            jtxtField2.setText("");
            jtxtField3.setText("");
            JOptionPane.showMessageDialog(this, "Se ha registrado la visita con exito");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha registrado la visita");
        }
    }                                        
    private void jButton2ActionPerformed(ActionEvent evt) { 
        this.dispose();
    } 
}
