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
public class VisitorForm extends JFrame{
    private JButton jButton1;
    private JButton jButton2;
    private JLabel title;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField jtxtField1;
    private JTextField jtxtField2;
    private JTextField jtxtField3;
    private JTextField jtxtField4;
    private JCheckBox checkMemberUV;
    private JCheckBox checkExternal;
    
    public VisitorForm(){
        super("Visitas - FEI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(180,100,900,500);
        this.setLayout(null);
        this.setVisible(true);
        
        checkMemberUV = new JCheckBox("Miembro de la UV");
        checkExternal = new JCheckBox("Externo a la UV");
        ButtonGroup groupCheckBoxes = new ButtonGroup(); 
        groupCheckBoxes.add(checkMemberUV);
        groupCheckBoxes.add(checkExternal);
        checkMemberUV.setBounds(650, 100, 200, 50);
        checkExternal.setBounds(650, 150, 200, 50);
        checkMemberUV.setSelected(true);
        this.add(checkMemberUV);
        this.add(checkExternal);
        
        title = new JLabel();
        title.setFont(new Font("Dialog", 0, 30));
        title.setText("Registro de Visitante");
        title.setBounds(320, 10, 600, 35);
        this.add(title);

        jLabel1 = new JLabel("Codigo de identificacion:");
        jLabel1.setFont(new Font("Dialog", 0, 15));
        jLabel1.setBounds(300,80,300,30);
        this.add(jLabel1);
        
        jtxtField1 = new JTextField();
        jtxtField1.setBounds(300,110,300,30);
        this.add(jtxtField1);

        jLabel2 = new JLabel("Nombre:");
        jLabel2.setFont(new Font("Dialog", 0, 15));
        jLabel2.setBounds(300,150,300,30);
        this.add(jLabel2);
        
        jtxtField2 = new JTextField();
        jtxtField2.setBounds(300,180,300,30);
        this.add(jtxtField2);
        
        jLabel3 = new JLabel("Apellido:");
        jLabel3.setFont(new Font("Dialog", 0, 15));
        jLabel3.setBounds(300,220,300,30);
        this.add(jLabel3);
        
        jtxtField3 = new JTextField();
        jtxtField3.setBounds(300,250,300,30);
        this.add(jtxtField3);

        jLabel4 = new JLabel("Correo:");
        jLabel4.setFont(new Font("Dialog", 0, 15));
        jLabel4.setBounds(300,290,300,30);
        this.add(jLabel4);
        
        jtxtField4 = new JTextField();
        jtxtField4.setBounds(300,320,300,30);
        this.add(jtxtField4);
        
        jButton1 = new JButton();
        jButton1.setText("Registrar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(250, 380, 150, 50);
        this.add(jButton1);
        
        jButton2 = new JButton();
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(500, 380, 150, 50);
        this.add(jButton2);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        Visitor visitor = new Visitor();
        if(checkMemberUV.isSelected()) {
            visitor.setBelonging("MemberUV");
        } else {
            visitor.setBelonging("External");
        }
        visitor.setId(jtxtField1.getText());
        visitor.setName(jtxtField2.getText());
        visitor.setLastname(jtxtField3.getText());
        visitor.setEmail(jtxtField4.getText());
        
        Validator validator = new Validator();
        if(validator.validateVisitorData(visitor)){
            VisitsManager visits = new VisitsManager();
            if(visits.registerAVisitor(visitor)) {
                jtxtField1.setText("");
                jtxtField2.setText("");
                jtxtField3.setText("");
                jtxtField4.setText("");
                JOptionPane.showMessageDialog(this, "Se ha guardado con exito");
            } else {
                JOptionPane.showMessageDialog(this, "No se ha guardado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha guardado");
        }
    }                                        
    private void jButton2ActionPerformed(ActionEvent evt) { 
        this.dispose();
    } 
}
