import java.util.ArrayList;
import java.util.List;

public class UpperCase implements Pretraiteur {

    public List<Noms> pretraiter(List<Noms> nom) {
        List<Noms> result = new ArrayList<>();
        for(Noms n : nom) {
            result.add(new Noms(n.getNom().toUpperCase(), n.getId()));
        }
        return result;
    }
}
