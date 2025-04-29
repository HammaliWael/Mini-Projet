import java.util.List;
import java.util.ArrayList;

public class DeleteChiffres implements Pretraiteur {
    public List<Noms> pretraiter (List<Noms> nom){
        List<Noms> result = new ArrayList<>();
        for(Noms n : nom) {
            result.add(new Noms(n.getNom().replaceAll("\\d ", ""), n.getId()));
        }
        return result;
    }

}

