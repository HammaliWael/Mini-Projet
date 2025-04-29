import java.util.List;
import java.util.ArrayList;

public class Vocalizer implements Pretraiteur {
    public List<Noms> pretraiter(List<Noms> nom){
        List<Noms> result = new ArrayList<>();
        for(Noms n : nom) {
            if (n.getNom().contains("oui")) {
                result.add(new Noms(n.getNom().replace("oui", "wi"), n.getId()));
            }

            if (n.getNom().contains("ss")) {
                result.add(new Noms(n.getNom().replace("ss", "z"), n.getId()));
            }
            if (n.getNom().contains("ph")) {
                result.add(new Noms(n.getNom().replace("ph", "f"), n.getId()));
            }
            if (n.getNom().contains("ck")) {
                result.add(new Noms(n.getNom().replace("ck", "k"), n.getId()));
            }
            if (n.getNom().contains("gh")) {
                result.add(new Noms(n.getNom().replace("gh", "g"), n.getId()));
            }
            if (n.getNom().contains("ks")) {
                result.add(new Noms(n.getNom().replace("ks", "x"), n.getId()));

            }
        }
        return result;

    }

}
