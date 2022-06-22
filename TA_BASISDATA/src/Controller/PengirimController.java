package Controller;
import AllObject.AllObjectModel;
import Entity.PengirimEntity;

import java.util.Date;
import java.util.ArrayList;

public class PengirimController implements ControllerInterface {
    @Override
    public ArrayList<PengirimEntity> getData(){
        return AllObjectModel.pengirimModel.getData();
    }
    public int UpdatePengirim(int id,String nama,String alamat, String no_hp, String username, String password, Date updated_at){
        return AllObjectModel.pengirimModel.getupdate(id, nama, alamat, no_hp,username,password, updated_at);
    }
    public void insertPengirim(int id,Date created_at, Date updated_at, String nama,String alamat, String no_hp, String username, String password ){
        AllObjectModel.pengirimModel.getInsert(new PengirimEntity(0,created_at,updated_at,nama, no_hp, alamat,username,password));
    }
   public void HapusPengirim(int IdHapus){
       AllObjectModel.pengirimModel.getdelete(IdHapus);
    
    }

   public int checkPengirim(String nama, String password){
        return AllObjectModel.pengirimModel.checkPengirim(nama, password);
   }
    
}