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


    public List<List<Nom>> generer(List<Nom> L1, List<Nom> L2){
        Map<Integer,List <Nom> >map = new HashMap<>();
        for(Nom n : L2) {
           if(map.containsKey(n.getNom().length())) {
               map.get(n.getNom().length()).add(n);
           }else {
               List<Nom> L = new ArrayList<>();
               L.add(n);
               map.put(n.getNom().length(),L);
           }

        }
        for(Nom n : L1) {
            int l=n.getNom().length();
            if(map.containsKey(l) ) {
                map.get(l).add(n);
                map.put(l,map.get(l));
            }
            else if(map.containsKey(l+x) ) {
                map.get(l+x).add(n);
                map.put(l+x,map.get(l+x));
            }
            else if(map.containsKey(l-2) ) {
                map.get(l-x).add(n);
                map.put(l-x,map.get(l-x));
            }
            else {
                List<Nom> L = new ArrayList<>();
                L.add(n);
                map.put(n.getNom().length(),L);
            }

        }
        return new ArrayList<>(map.values());


    }






}
