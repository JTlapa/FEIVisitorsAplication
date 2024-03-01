package mx.fei.visitorsfeiapp.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import mx.fei.visitorsfeiapp.logic.VisitsManager;

public class CheckOut extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel title;
    private JLabel jLabel1;
    private JTextField jtxtField1;
    
    public CheckOut() {
        super("Visitas - FEI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(180, 100, 900, 500);
        this.setLayout(null);
        this.setVisible(true);
        
        title = new JLabel();
        title.setFont(new Font("Dialog", 0, 30));
        title.setText("Registro de salida");
        title.setBounds(320, 10, 600, 35);
        this.add(title);

        jLabel1 = new JLabel("Codigo de identificacion:");
        jLabel1.setFont(new Font("Dialog", 0, 15));
        jLabel1.setBounds(300, 150, 300, 30);
        this.add(jLabel1);
        
        jtxtField1 = new JTextField();
        jtxtField1.setBounds(300, 200,300, 30);
        this.add(jtxtField1);
        
        jButton1 = new JButton();
        jButton1.setText("Registrar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(250, 320, 150, 50);
        this.add(jButton1);
        
        jButton2 = new javax.swing.JButton();
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(500, 320, 150, 50);
        this.add(jButton2);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        VisitsManager visits = new VisitsManager();
        if(visits.registerCheckOut(jtxtField1.getText()) == 1) {
            jtxtField1.setText("");
            JOptionPane.showMessageDialog(this, "Se ha guardado su hora de salida");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha registrado su hora de entrada");
        }
    }                                        
    private void jButton2ActionPerformed(ActionEvent evt) {  
        this.dispose();
    } 
}
