package Entity;
import java.util.Date;
import java.util.List;

public abstract class EntityAbstract {
    protected int id;
    protected Date kirim_at, terima_at;
    
    public EntityAbstract(){}
    
    public EntityAbstract(int id, Date kirim_at, Date terima_at){
    this.id = id;
    this.kirim_at = kirim_at;
    this.terima_at = terima_at;
    }
    
    public EntityAbstract(int id){
    this.id = id;
    }
    
    public int getId(){
    return id;
    }

    public Date getKirim_at() {
        return kirim_at;
    }

    public Date getTerima_at() {
        return terima_at;
    }
    
}
