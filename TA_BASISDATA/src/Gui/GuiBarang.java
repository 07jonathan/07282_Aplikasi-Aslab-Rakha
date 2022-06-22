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

public class GuiBarang extends Komponen {

    DefaultTableModel modelBar;
    JScrollPane sp_Pengirim = new JScrollPane();
    JTable tbl_Pengirim = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiBarang(int cek) {
        initComponent(cek);
    }

    public void initComponent(final int cek){
        int nama = AllObjectController.penerimaController.getData().get(cek).getId();
        setSize(1000 , 500);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        labelUsername.setBounds(20, 0, 100, 25);
        labelUsername.setFont(new Font("Arial" , Font.BOLD,14));
        add(labelUsername);
        txtUsername.setBounds(100, 4, 100, 25);
        txtUsername.setText(String.valueOf(nama-1));
        txtUsername.setEditable(false);
        add(txtUsername);
        
        labelId.setBounds(20 , 30 , 70 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(90 , 34, 150 , 20);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 60 , 70 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(90 , 64, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelJenis.setBounds(20 , 90 , 80 , 30);
        labelJenis.setFont(new Font("Arial" , Font.BOLD,14));
        txtJenis.setBounds(90 , 94, 150 , 20);
        add(labelJenis);
        add(txtJenis);

        labelPenerima.setBounds(20 , 120 , 100 , 30);
        labelPenerima.setFont(new Font("Arial" , Font.BOLD,14));
        txtPenerima.setBounds(100 , 124, 150 , 20);
        add(labelPenerima);
        add(txtPenerima);

        sp_Pengirim.setViewportView(tbl_Pengirim);
        modelBar = (DefaultTableModel) tbl_Pengirim.getModel();
        tbl_Pengirim.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Jenis");
        modelBar.addColumn("Pengirim");
        modelBar.addColumn("Penerima");
        modelBar.addColumn("Admin");
        modelBar.addColumn("Kurir");
        modelBar.addColumn("Tanggal kirim");
        modelBar.addColumn("Tanggal terima");
        modelBar.addColumn("Status");
        
        sp_Pengirim.setBounds(20 , 300 , 1320 , 400);
        add(sp_Pengirim);
        
        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnKeluar.setBounds(20 , 210 , 100 , 30);
        add(btnKeluar);

//        Cetak data dulu

        cetakPengirim();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    String penerima = txtPenerima.getText();
                    int alex = Integer.parseInt(penerima);
                    String username = txtUsername.getText();
                    int nameuser = Integer.parseInt(username);
                    AllObjectController.barangController.insertBarang( 0,txtNama.getText(),txtJenis.getText(),new Date(),new Date(),nameuser,alex,1,1,"diproses");
                    
                    cetakPengirim();
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
        
//        tbl_Pengirim.addMouseListener(new MouseAdapter()
//		{
//                    @Override
//			public void mouseClicked(MouseEvent me)
//			{
//				int pilih = tbl_Pengirim.getSelectedRow();
//				if(pilih == -1)
//				{
//					return;
//				}
//				
//				int id = (int) tbl_Pengirim.getValueAt(pilih, 0);
//                                String dimana = String.valueOf(id);
//				txtId.setText(dimana);
//				String nama = (String) tbl_Pengirim.getValueAt(pilih, 1);
//				txtNama.setText(nama);
//				String jenis = (String) tbl_Pengirim.getValueAt(pilih, 2);
//				txtJenis.setText(jenis);
//                        }
//		});
    }

    public void cetakPengirim(){
        String username = txtUsername.getText();
                    int nameuser = Integer.parseInt(username);
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[10];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getJenis();
            obj[3] = AllObjectController.barangController.getData().get(i).getPengirim();
            obj[4] = AllObjectController.barangController.getData().get(i).getPenerima();
            obj[5] = AllObjectController.barangController.getData().get(i).getAdmin();
            obj[6] = AllObjectController.barangController.getData().get(i).getKurir();
            obj[7] = AllObjectController.barangController.getData().get(i).getKirim_at();
            obj[8] = AllObjectController.barangController.getData().get(i).getTerima_at();
            obj[9] = AllObjectController.barangController.getData().get(i).getStatus();
            int  kirim = AllObjectController.barangController.getData().get(i).getPengirim();
            int  terima = AllObjectController.barangController.getData().get(i).getPenerima();
            if(kirim == nameuser || terima == nameuser){
                    modelBar.addRow(obj);
                }             
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
