package Gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu extends Komponen {

    public GuiMenu() {
        initComponent();
    }

    public void initComponent(){
        setSize(300 , 300);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        btnPengirim.setBounds(5 , 10 , 275 , 100);
        btnPengirim.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnPengirim);

        btnBarang.setBounds(4, 130 , 275 , 100);
        btnBarang.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnBarang);

        
        btnKeluar.setBounds(6 , 250 , 275 , 100);
        btnBarang.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnKeluar);
        
        btnPengirim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               // new GuiBarang().setVisible(true);
            }
        });

        btnBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //new GuiKurir().setVisible(true);
            }
        });
        
        
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiAdmin().setVisible(true);
            }
        });
        
        
    }
}
