import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class SelectionneurParSeuille {
    int seuil;

    public SelectionneurParSeuille(int seuil){
        this.seuil = seuil;
    }

    public int getSeuil(){ return seuil; }

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
