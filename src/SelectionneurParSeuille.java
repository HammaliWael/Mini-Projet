import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class SelectionneurParSeuille {
    int seuil;

    public SelectionneurParSeuille(int seuil){
        this.seuil = seuil;
    }
    public List<MyTuple> selectionner(List<MyTuple> L){
        for(MyTuple t : L){
            if(t.getValue() < seuil) {
                L.remove(t);
            }
        }
        return L;
    }

}
