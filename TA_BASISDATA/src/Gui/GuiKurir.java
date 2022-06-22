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

public class GuiKurir extends Komponen {

    DefaultTableModel modelBar;
    JScrollPane sp_Kurir = new JScrollPane();
    JTable tbl_Kurir = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiKurir(int usr) {
        initComponent(usr);
    }

    public void initComponent(final int usr){
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

        sp_Kurir.setViewportView(tbl_Kurir);
        modelBar = (DefaultTableModel) tbl_Kurir.getModel();
        tbl_Kurir.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Stok");
        modelBar.addColumn("Harga");
        modelBar.addColumn("Created_at");
        modelBar.addColumn("Updated_at");
        sp_Kurir.setBounds(380 , 30 , 400 , 400);
        add(sp_Kurir);
        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        
       
//        Cetak data dulu

        cetakKurir();
        
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    
                    int id = Integer.parseInt(txtId.getText());
                    AllObjectController.barangController.UpdateBarang(id,"diterima");
                    cetakKurir();
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
        
        tbl_Kurir.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Kurir.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				int id = (int) tbl_Kurir.getValueAt(pilih, 0);
                                String dimana = String.valueOf(id);
				txtId.setText(dimana);
				String nama = (String) tbl_Kurir.getValueAt(pilih, 1);
				txtNama.setText(nama);
				String jenis = (String) tbl_Kurir.getValueAt(pilih, 2);
				txtJenis.setText(jenis);
				
                        }
		});
    }

    public void cetakKurir(){
        String username = txtUsername.getText();
                    int nameuser = Integer.parseInt(username);
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[7];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getJenis();
            obj[3] = AllObjectController.barangController.getData().get(i).getPengirim();
            obj[4] = AllObjectController.barangController.getData().get(i).getPenerima();
            obj[5] = AllObjectController.barangController.getData().get(i).getKurir();
            obj[6] = AllObjectController.barangController.getData().get(i).getStatus();
            int  kurir = AllObjectController.barangController.getData().get(i).getPengirim();
            if(kurir == nameuser){
                    modelBar.addRow(obj);
                }             
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
