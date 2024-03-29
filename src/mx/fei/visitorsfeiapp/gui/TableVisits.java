package mx.fei.visitorsfeiapp.gui;

import mx.fei.visitorsfeiapp.logic.VisitsManager;
import mx.fei.visitorsfeiapp.logic.Visit;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class TableVisits extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel title;
    private JLabel jLabel1;
    private JTextField jtxtField1;
    private JTextArea table;
    private JScrollPane scroll;
    private JLabel column;
    
    public TableVisits() {
        super("Visitas - FEI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(180,100,900,500);
        this.setLayout(null);
        this.setVisible(true);
        
        title = new JLabel();
        title.setFont(new Font("Dialog", 0, 30));
        title.setText("Visitas registradas por fecha");
        title.setBounds(260, 10, 600, 35);
        this.add(title);

        jLabel1 = new JLabel("Fecha a buscar:");
        jLabel1.setFont(new Font("Dialog", 0, 15));
        jLabel1.setBounds(200,80,150,30);
        this.add(jLabel1);
        
        jtxtField1 = new JTextField("2024-01-01");
        jtxtField1.setBounds(351,80,100,30);
        this.add(jtxtField1);
        
        jButton1 = new JButton();
        jButton1.setText("Buscar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(460, 70, 150, 50);
        this.add(jButton1);
        
        jButton2 = new javax.swing.JButton();
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(625, 70, 150, 50);
        this.add(jButton2);
        
        column = new JLabel("Pertenencia");
        column.setBounds(12, 160, 100, 20);
        this.add(column);
        column = new JLabel("Identificacion");
        column.setBounds(112, 160, 100, 20);
        this.add(column);
        column = new JLabel("Nombre");
        column.setBounds(212, 160, 100, 20);
        this.add(column);
        column = new JLabel("Correo");
        column.setBounds(312, 160, 200, 20);
        this.add(column);
        column = new JLabel("Asunto");
        column.setBounds(512, 160, 100, 20);
        this.add(column);
        column = new JLabel("Entrada");
        column.setBounds(612, 160, 100, 20);
        this.add(column);
        column = new JLabel("Salida");
        column.setBounds(712, 160, 100, 20);
        this.add(column);
        
        table = new JTextArea();
        table.setEditable(false);
        table.setWrapStyleWord(true);
        table.setBackground(Color.lightGray);
        
        scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10,180,860,270);
        this.add(scroll);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        Validator validator = new Validator();
        VisitsManager visitsManager = new VisitsManager();
        if(validator.validateDate(jtxtField1.getText())) {
            ArrayList<Visit> visits = null;
            visits = visitsManager.getVisitsByDay(jtxtField1.getText());
            if(visits.isEmpty()){
                JOptionPane.showMessageDialog(this, "No existen registros en esa fecha");
            } else {
                int YPosition = 5;
                JPanel panelVisit;
                JLabel columnData;
                for(Visit visitor : visits){
                    panelVisit = new JPanel();
                    panelVisit.setBounds(5, YPosition, 800, 40);
                    columnData = new JLabel(visitor.getBelonging());
                    columnData.setBounds(10,10,80,20);
                    panelVisit.add(columnData);
                    columnData = new JLabel(visitor.getId());
                    columnData.setBounds(100,10,80,20);
                    panelVisit.add(columnData);
                    columnData = new JLabel(visitor.getName());
                    columnData.setBounds(200,10,80,20);
                    panelVisit.add(columnData);
                    columnData = new JLabel(visitor.getEmail());
                    columnData.setBounds(300,10,170,20);
                    panelVisit.add(columnData);
                    columnData = new JLabel(visitor.getSubject());
                    columnData.setBounds(500,10,80,20);
                    panelVisit.add(columnData);
                    columnData = new JLabel(visitor.getEntryTime());
                    columnData.setBounds(600,10,80,20);
                    panelVisit.add(columnData);
                    columnData = new JLabel(visitor.getDepartureTime());
                    columnData.setBounds(700,10,80,20);
                    panelVisit.add(columnData);
                    table.add(panelVisit);
                    YPosition += 45;
                }
                table.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Formato de fecha invalido (aaaa-mm-dd)");
        }
    }                                        
    private void jButton2ActionPerformed(ActionEvent evt) {     
        this.dispose();
    } 
}
