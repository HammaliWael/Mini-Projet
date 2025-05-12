import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generateur1 implements GenerateurDeCondidat {

    private int x;

    public Generateur1(int x){
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public List<MyTuple> generer(List<Nom> L1, List<Nom> L2) {

        Map<Integer, List<Nom>> map = new HashMap<>();
        for (Nom n : L2) {
            int len = n.getNom().length();
            map.computeIfAbsent(len, k -> new ArrayList<>()).add(n);
        }

        List<MyTuple> result = new ArrayList<>();
        for (Nom n1 : L1) {
            int len = n1.getNom().length();
            if (map.containsKey(len)) {
                for (Nom n2 : map.get(len)) {
                    result.add(new MyTuple(n1,n2,0.0));
                }
            }
            if (map.containsKey(len+x)) {
                for (Nom n2 : map.get(len+x)) {
                    result.add(new MyTuple(n1,n2,0.0));
                }
             }
            if (map.containsKey(len-x)) {
                for (Nom n2 : map.get(len-x)) {
                    result.add(new MyTuple(n1,n2,0.0));
                }
            }
        }

        return result;
    }
}

