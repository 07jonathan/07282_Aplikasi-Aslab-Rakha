package Entity;

import java.util.Date;

public class PenerimaEntity extends EntityAbstract {
    protected String  nama, alamat,password, notelp;
    
    public PenerimaEntity(){}

    public PenerimaEntity(int id, String nama,String alamat, String notelp, String password ) {
        super(id);
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
