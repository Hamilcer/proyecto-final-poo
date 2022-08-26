package interfaz;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.plaf.DimensionUIResource;

public class interfazBienvenida extends javax.swing.JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JPanel jPanel1;  

    public interfazBienvenida() {
        initComponents();
    }     

    private void initComponents() {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setMinimumSize(new DimensionUIResource(400, 400));
        jLabel1.setFont(new Font ("Comic Sans MS",Font.PLAIN,14));
        jPanel1.setBackground(Color.PINK);
        jButton1.setBackground(Color.WHITE);
        jButton1.setFont(new Font ("Comic Sans MS",Font.PLAIN,12));
        jButton2.setBackground(Color.WHITE);
        jButton2.setFont(new Font ("Comic Sans MS",Font.PLAIN,12));
        setLocationRelativeTo(null);

        jButton1.setText("1vs1");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VsMáquina");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenido al othello, elige el modo de juego: ");

        javax.swing.GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                     

    private void jButton1ActionPerformed(ActionEvent evt) {
        new interfazOthello(1).setVisible(true);
        setVisible(false);
    }                                        
    
    private void jButton2ActionPerformed(ActionEvent evt) {  
        new interfazOthello(2).setVisible(true);
        setVisible(false);
    }                    
     
       
} 