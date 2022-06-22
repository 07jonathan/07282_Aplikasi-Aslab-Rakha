package Gui;


import AllObject.AllObjectController;
import Entity.BarangEntity;
import Gui.Komponen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GuiAdmin extends Komponen {

    DefaultTableModel modelBar;
    JScrollPane sp_Mhs = new JScrollPane();
    JTable tbl_Mhs = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiAdmin() {
        initComponent();
    }

    public void initComponent(){
        setSize(1000 , 500);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20 , 0 , 70 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(90 , 4, 150 , 20);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 30 , 70 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(90 , 34, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelJenis.setBounds(20 , 60 , 70 , 30);
        labelJenis.setFont(new Font("Arial" , Font.BOLD,14));
        txtJenis.setBounds(90 , 64, 150 , 20);
        add(labelJenis);
        add(txtJenis);

        labelPenerima.setBounds(20 , 90 , 70 , 30);
        labelPenerima.setFont(new Font("Arial" , Font.BOLD,14));
        txtPenerima.setBounds(90 , 94, 150 , 20);
        add(labelPenerima);
        add(txtPenerima);

        sp_Mhs.setViewportView(tbl_Mhs);
        modelBar = (DefaultTableModel) tbl_Mhs.getModel();
        tbl_Mhs.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Jenis");
        modelBar.addColumn("pengirim");
        modelBar.addColumn("penerima");
        modelBar.addColumn("Admin");
        modelBar.addColumn("Kurir");
        modelBar.addColumn("Status");
        
        sp_Mhs.setBounds(380 , 30 , 400 , 400);
        add(sp_Mhs);
        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);
        
        btnKeluar.setBounds(20 , 210 , 100 , 30);
        add(btnKeluar);

//        Cetak data dulu

        cetakMhs();
        
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    
                    int id = Integer.parseInt(txtId.getText());
                    AllObjectController.barangController.UpdateBarang(id,"dikirim");
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiLogin().setVisible(true);
            }
        });
        
        tbl_Mhs.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Mhs.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				int id = (int) tbl_Mhs.getValueAt(pilih, 0);
                                String dimana = String.valueOf(id);
				txtId.setText(dimana);
				String nama = (String) tbl_Mhs.getValueAt(pilih, 1);
				txtNama.setText(nama);
				String jenis = (String) tbl_Mhs.getValueAt(pilih, 2);
				txtJenis.setText(jenis);
				
                        }
		});
    }

     public void cetakMhs(){
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[8];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getJenis();
            obj[3] = AllObjectController.barangController.getData().get(i).getPengirim();
            obj[4] = AllObjectController.barangController.getData().get(i).getPenerima();
            obj[5] = AllObjectController.barangController.getData().get(i).getAdmin();
            obj[6] = AllObjectController.barangController.getData().get(i).getKurir();
            
            obj[7] = AllObjectController.barangController.getData().get(i).getStatus();
            
                
                modelBar.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
