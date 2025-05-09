import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class SelectionneurNmeilleur implements Selectionneur {
    int n;
    public SelectionneurNmeilleur(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public List<MyTuple> selectionner(List<MyTuple> L) {
        L.sort(Comparator.comparingDouble(MyTuple::getValue).reversed());
        if(L.size()<n) return L;
        else {
            L=L.subList(0,n);
            return L;
        }
    }
}