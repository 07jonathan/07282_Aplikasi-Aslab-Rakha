package Model;
import Core.Main;
import Entity.BarangEntity;
import Helper.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class KurirModel {
    private String sql;
    public Connection conn = Koneksi.getconection();
    public int checkKurir(String nama, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM kurir WHERE id_kurir='"+nama+"' AND password_kurir='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(nama.equals(rs.getString("id_kurir")) && password.equals(rs.getString("password_kurir"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt("id_kurir");
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
