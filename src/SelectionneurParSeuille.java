import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class SelectionneurParSeuille implements Selectionneur {
    double seuil;

    public SelectionneurParSeuille(Double seuil){
        this.seuil = seuil;
    }

    public Double getSeuil(){ return seuil; }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    public List<MyTuple> selectionner(List<MyTuple> L){
        List<MyTuple> result = new ArrayList<>();
        for(MyTuple t : L){
            if(t.getValue() >= seuil) {
                result.add(t);
            }
        }
        return result;
    }

}
