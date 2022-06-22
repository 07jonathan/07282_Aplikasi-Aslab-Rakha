package Model;

import Entity.PenerimaEntity;
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

public class PenerimaModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<PenerimaEntity> penerimaEntity = new ArrayList<PenerimaEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();
    
    @Override
    public ArrayList<PenerimaEntity> getData(){
        ArrayList<PenerimaEntity> arraylistPenerima = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from penerima";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id;
                String nama,alamat, notelp,password;
                id = rs.getInt("id_penerima");
                nama =rs.getString("nama_penerima");
                alamat =rs.getString("alamat_penerima");
                password = rs.getString("password_penerima");
                notelp = rs.getString("notelp_penerima");
                
                arraylistPenerima.add(new PenerimaEntity(id,nama,alamat,  password, notelp ));
            }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistPenerima;
    }
    
    public void getInsert(PenerimaEntity penerimaEntity){
        try{
            sql = "INSERT INTO penerima (nama_penerima,alamat_penerima,notelp_penerima,password_penerima) values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,penerimaEntity.getNama());
            preparedStatement.setString(2,penerimaEntity.getAlamat());
            preparedStatement.setString(3,penerimaEntity.getNotelp());
            preparedStatement.setString(4,penerimaEntity.getPassword());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int getupdate( int id,String nama, String alamat, String no_hp,String password) {
        int row = 0;
    try {
            Statement stat = conn.createStatement();
            Date date= new java.util.Date();
            String sql = "UPDATE penerima SET nama_penerima = ?,alamat_penerima =?,notelp_penerima =?,password =? WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setString(2,alamat);
            ps.setString(3, no_hp);
            ps.setString(4, password);
            ps.setInt(5,id);
            row = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return row;
     }
    
    
       public ArrayList<PenerimaEntity> getdelete(int id) {
         ArrayList<PenerimaEntity> arraylistPenerima = new ArrayList<>();
         try {
           Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM penerima WHERE id=%d", id);
            stat.execute(sql);
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistPenerima;
      }
       
       
       public int checkPenerima(String username, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM penerima WHERE id_penerima='"+username+"' AND password_penerima='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.equals(rs.getString("id_penerima")) && password.equals(rs.getString("password_penerima"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt("id_penerima");
                }
            }else{
                    System.out.println("gagal login");
                    cek=0;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cek;
    }
   
}
