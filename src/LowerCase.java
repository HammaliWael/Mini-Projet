import java.util.ArrayList;
import java.util.List;

public class LowerCase implements Pretraiteur {
    public List<Noms> pretraiter(List<Noms> nom){
        List<Noms> result = new ArrayList<>();
        for(Noms n : nom) {
            result.add(new Noms(n.getNom().toLowerCase(), n.getId()));
        }
        return result;
    }
}
