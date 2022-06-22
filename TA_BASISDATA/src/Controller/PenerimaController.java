package Controller;
import AllObject.AllObjectModel;
import Entity.PenerimaEntity;

import java.util.Date;
import java.util.ArrayList;

public class PenerimaController implements ControllerInterface {
    @Override
    public ArrayList<PenerimaEntity> getData(){
        return AllObjectModel.penerimaModel.getData();
    }
    public int UpdatePenerima(int id,String nama,String alamat, String no_hp, String password){
        return AllObjectModel.penerimaModel.getupdate(id, nama, alamat, no_hp,password);
    }
    public void insertPenerima(int id,String nama,String alamat, String notelp, String password ){
        AllObjectModel.penerimaModel.getInsert(new PenerimaEntity(0,nama, alamat,notelp, password));
    }
   public void HapusPenerima(int IdHapus){
       AllObjectModel.penerimaModel.getdelete(IdHapus);
    
    }

   public int checkPenerima(String nama, String password){
        return AllObjectModel.penerimaModel.checkPenerima(nama, password);
   }
    
}