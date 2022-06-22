package Entity;
import Helper.Koneksi;
import java.util.Date;

public class BarangEntity extends EntityAbstract {
    protected String nama;
    protected String jenis;
    protected String status;
    protected int  pengirim;
    protected int  penerima;
    protected int  admin;
    protected int  kurir;
    
    
    public BarangEntity(){}

    public BarangEntity(int id,  String nama, String jenis,Date kirim_at, Date terima_at,int pengirim,int penerima,int kurir,int admin, String status) {
        super(id,kirim_at,terima_at);
        this.nama = nama;
        this.jenis = jenis;
        this.status =status;
        this.penerima =penerima;
        this.pengirim =pengirim;
        this.kurir =kurir;
        this.admin =admin;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

     public int  getKurir() {
        return kurir;
    }

    public void setKurir(int  kurir) {
        this.kurir = kurir;
    }
 public int  getAdmin() {
        return admin;
    }

    public void setAdmin(int  admin) {
        this.admin = admin;
    }
    public int getPengirim() {
        return pengirim;
    }

    public void setPengirim(int pengirim) {
        this.pengirim = pengirim;
    }

    public int getPenerima() {
        return penerima;
    }

    public void setPenerima(int penerima) {
        this.penerima = penerima;
    }

    @Override
    public Date getTerima_at() {
        return super.getTerima_at(); 
    }

    @Override
    public Date getKirim_at() {
        return super.getKirim_at(); 
    }

    @Override
    public int getId() {
        return super.getId(); 
    }   
}
