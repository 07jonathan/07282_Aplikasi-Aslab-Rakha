package Controller;
import AllObject.AllObjectModel;
import Entity.BarangEntity;
import Controller.ControllerInterface;
import java.util.Date;
import java.util.ArrayList;

public class BarangController implements ControllerInterface {
    @Override
    public ArrayList<BarangEntity> getData(){
        return AllObjectModel.barangModel.getData();
    }
    
    public void insertBarang(int Id, String Nama, String jenis,Date kirim_at,Date terima_at, int pengirim, int penerima, int kurir,int admin, String status){
        AllObjectModel.barangModel.getInsert(new BarangEntity(0, Nama, jenis,kirim_at,terima_at,pengirim,penerima,kurir,admin, status));
                    
    }

    public int UpdateBarang(int Id,  String status){
        return AllObjectModel.barangModel.getupdate(Id,status);
        
    }
    
}
