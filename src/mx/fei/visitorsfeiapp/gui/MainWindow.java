package mx.fei.visitorsfeiapp.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class MainWindow extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel title;
    
    public MainWindow() {
        super("Visitas - FEI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(180,100,900,500);
        this.setLayout(null);
        this.setVisible(true);
        
        title = new JLabel();
        title.setFont(new Font("Dialog", 0, 30));
        title.setText("Registro de visitas - FEI");
        title.setBounds(290, 10, 600, 35);
        this.add(title);

        jButton1 = new JButton();
        jButton1.setText("Registrar entrada");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed();
            }
        });
        jButton1.setBounds(150, 130, 200, 100);
        this.add(jButton1);

        jButton2 = new javax.swing.JButton();
        jButton2.setText("Registrar salida");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed();
            }
        });
        jButton2.setBounds(550, 130, 200, 100);
        this.add(jButton2);

        jButton3 = new javax.swing.JButton();
        jButton3.setText("Capturar datos");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed();
            }
        });
        jButton3.setBounds(150, 280, 200, 100);
        this.add(jButton3);

        jButton4 = new javax.swing.JButton();
        jButton4.setText("Consultar registro  por fecha");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed();
            }
        });
        jButton4.setBounds(550, 280, 200, 100);
        this.add(jButton4);
    }                                     

    private void jButton1ActionPerformed() {                                         
        new CheckIn();
    }                                        
    private void jButton2ActionPerformed() {
        new CheckOut();
    } 
    private void jButton3ActionPerformed() {
        new VisitorForm();
    }   
    private void jButton4ActionPerformed() { 
        new LogIn();
    }   
}
