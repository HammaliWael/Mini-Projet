import java.util.List;

public class DeleteChiffres implements Pretraiteur {
    public List<Nom> pretraiter(List<Nom> Noms){

        for(Nom n : Noms) {
            List<Nom> L = n.getListNomTraitees();
            for(int i=0;i<L.size();i++) {
                String cleaned = L.get(i).getNom().replaceAll("\\d", "");
                L.get(i).setNom(cleaned);
            }
            n.setListNomTraitees(L);

        }
        return Noms;
    }

}