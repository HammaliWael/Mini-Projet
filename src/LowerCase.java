import java.util.List;

public class LowerCase implements Pretraiteur {
    public List<Nom> pretraiter(List<Nom> Noms){
        for(Nom n : Noms) {
            List<Nom> L =n.getListNomTraitees();
            for(int i = 0 ; i < L.size() ; i++) {
                L.get(i).setNom(L.get(i).getNom().toLowerCase());
            }
            n.setListNomTraitees(L);
        }
        return Noms;
    }
}