import java.util.List;

public class Vocalizer implements Pretraiteur {
    public List<Nom> pretraiter(List<Nom> Noms) {
        for (Nom n : Noms) {
            List<Nom> L = n.getListNomTraitees();
            for (int i = 0; i < L.size(); i++) {
                if (L.get(i).getNom().contains("oui")) {
                    L.get(i).getNom().replace("oui", "wi");
                }

                if (L.get(i).getNom().contains("ss")) {
                    L.get(i).getNom().replace("ss", "z");
                }
                if (L.get(i).getNom().contains("ph")) {
                    L.get(i).getNom().replace("ph", "f");
                }
                if (L.get(i).getNom().contains("ck")) {
                    L.get(i).getNom().replace("ck", "k");
                }
                if (L.get(i).getNom().contains("gh")) {
                    L.get(i).getNom().replace("gh", "g");
                }
                if (n.getNom().contains("ks")) {
                    L.get(i).getNom().replace("ks", "x");

                }
            }
            n.setListNomTraitees(L);

        }
        return Noms;
    }
}