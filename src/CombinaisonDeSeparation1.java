import java.util.*;

public class CombinaisonDeSeparation1 implements Pretraiteur {

    @Override
    public List<Nom> pretraiter(List<Nom> noms) {
        for (Nom n1 : noms) {
            List<Nom> L = new ArrayList<>();
            L=n1.getListNomTraitees();
            if(L.isEmpty()) continue;
            else{
                for (Nom n2 : L){
                    String[] parts = n2.getNom().trim().split("[\\s\\-_]+");
                    Collections.sort(Arrays.asList(parts));
                    String s= String.join(" ", parts);
                    n2.setNom(s);
                }
            }

        }
        return noms;
    }
}