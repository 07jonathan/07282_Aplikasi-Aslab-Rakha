package Model;

import Entity.PengirimEntity;
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

public class PengirimModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<PengirimEntity> pengirimEntity = new ArrayList<PengirimEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();
    
    @Override
    public ArrayList<PengirimEntity> getData(){
        ArrayList<PengirimEntity> arraylistPengirim = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from pengirim";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id;
                String nama, alamat,no_hp,username, password;
                Date created_at,updated_at;
                id = rs.getInt("id");
                nama =rs.getString("nama");
                alamat = rs.getString("alamat");
                no_hp = rs.getString("no_hp");
                username= rs.getString("username");
                password= rs.getString("password");
                created_at =rs.getTimestamp("created_at");
                updated_at=rs.getTimestamp("updated_at");
                
                arraylistPengirim.add(new PengirimEntity(id, created_at, updated_at, nama, no_hp, alamat, username, password ));
            }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistPengirim;
    }
    
    public void getInsert(PengirimEntity pengirimEntity){
        try{
            sql = "INSERT INTO pengirim (nama,alamat,no_hp,username,password,created_at,updated_at) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,pengirimEntity.getNama());
            preparedStatement.setString(2,pengirimEntity.getAlamat());
            preparedStatement.setString(3,pengirimEntity.getNo_hp());
            preparedStatement.setString(4,pengirimEntity.getUsername());
            preparedStatement.setString(5,pengirimEntity.getPassword());
            preparedStatement.setTimestamp(6,new Timestamp(pengirimEntity.getKirim_at().getTime()));
            preparedStatement.setTimestamp(7,new Timestamp(pengirimEntity.getTerima_at().getTime()));
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int getupdate( int id,String nama, String alamat, String no_hp,String username, String password, Date updated_at) {
        int row = 0;
    try {
            Statement stat = conn.createStatement();
            Date date= new java.util.Date();
            String sql = "UPDATE pengirim SET nama = ?,alamat =?,no_hp =?,username =?,password =?,updated_at=? WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setString(2,alamat);
            ps.setString(3, no_hp);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setTimestamp(6, new Timestamp(updated_at.getTime()));
            ps.setInt(7,id);
            row = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return row;
     }
    
    
       public ArrayList<PengirimEntity> getdelete(int id) {
         ArrayList<PengirimEntity> arraylistPengirim = new ArrayList<>();
         try {
           Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM pengirim WHERE id=%d", id);
            stat.execute(sql);
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistPengirim;
      }
       
       
       public int checkPengirim(String username, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pengirim WHERE username='"+username+"' AND password='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt("id");
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
