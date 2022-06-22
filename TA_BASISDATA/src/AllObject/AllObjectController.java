 package AllObject;
import Controller.BarangController;
import Controller.PengirimController;
import Controller.PenerimaController;
import Controller.AdminController;
import Controller.KurirController;
import java.util.Date;

public class AllObjectController {
    public static PengirimController pengirimController = new PengirimController();
    public static KurirController kurirController = new KurirController();
    public static PenerimaController penerimaController = new PenerimaController();
    public static BarangController barangController = new BarangController();
    public static AdminController adminController = new AdminController();
    
}
