package Model;
import Core.Main;
import Entity.BarangEntity;
import Helper.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminModel {
    private String sql;
    public Connection conn = Koneksi.getconection();
    public int checkAdmin(String nama, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin WHERE id_admin='"+nama+"' AND password_admin='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(nama.equals(rs.getString("id_admin")) && password.equals(rs.getString("password_admin"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt("id_admin")+1;
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
