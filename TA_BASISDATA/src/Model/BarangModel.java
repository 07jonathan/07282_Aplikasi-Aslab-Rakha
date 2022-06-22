package Model;

import Entity.BarangEntity;
import Helper.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Timestamp;


public class BarangModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<BarangEntity> barangEntity = new ArrayList<BarangEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();

@Override    
    public ArrayList<BarangEntity> getData(){
        ArrayList<BarangEntity> arraylistBarang = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from barang";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id,kurir,admin, pengirim,penerima;
                String nama, jenis, status;
                Date kirim_at, terima_at;
                id = rs.getInt("id_barang");
                nama=rs.getString("nama_barang");
                jenis = rs.getString("jenis_barang");
                pengirim = rs.getInt("pengirim_id");
                penerima = rs.getInt("penerima_id");
                kurir = rs.getInt("kurir_id");
                admin = rs.getInt("admin_id");
                status = rs.getString("status_barang");
                kirim_at =rs.getTimestamp("kirim_at");
                terima_at=rs.getTimestamp("terima_at");
     
                arraylistBarang.add(new BarangEntity(id, nama, jenis,kirim_at,terima_at,pengirim,penerima,kurir,admin,status));
                }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistBarang;
    }
    
    public void getInsert(BarangEntity barangEntity){
        try{
            sql = "INSERT INTO "
                    + "barang (nama_barang, jenis_barang,status_barang, kirim_at, terima_at, kurir_id,admin_id,pengirim_id,penerima_id) "
                    + "values (?,?,?,current_timestamp(), NULL,1,1,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,barangEntity.getNama());
            preparedStatement.setString(2,barangEntity.getJenis());
            preparedStatement.setString(3,barangEntity.getStatus());
            //preparedStatement.setInt(4,barangEntity.getKurir());
            //preparedStatement.setInt(5,barangEntity.getAdmin());
            //preparedStatement.setTimestamp(3,new Timestamp(barangEntity.getKirim_at().getTime()));
            //preparedStatement.setTimestamp(4,new Timestamp(barangEntity.getTerima_at().getTime()));
            preparedStatement.setInt(4,barangEntity.getPengirim());
            preparedStatement.setInt(5,barangEntity.getPenerima());
            
            
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(barangEntity.getKurir());
        }
    }
    
    public int getupdate( int id,String status) {
        int row = 0;
    try {
            Statement stat = conn.createStatement();
            Date date= new java.util.Date();
            String sql = "UPDATE barang SET status_barang =? WHERE id_barang=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2,id);
            // update data buku
            row = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return row;
     }
    
    
}
