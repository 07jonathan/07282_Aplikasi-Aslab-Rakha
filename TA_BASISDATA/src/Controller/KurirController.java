package Controller;

import AllObject.AllObjectModel;

public class KurirController {
    public int checkKurir(String nama, String password){
        return AllObjectModel.kurirModel.checkKurir(nama, password);
    }
}
