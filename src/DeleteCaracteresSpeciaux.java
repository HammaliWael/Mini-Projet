import java.util.List;
import java.util.ArrayList;
public class DeleteCaracteresSpeciaux implements Pretraiteur {
    public List<Noms> pretraiter(List<Noms> nom){
        List<Noms> result = new ArrayList<>();
        for(Noms n : nom) {
            result.add(new Noms(n.getNom().replaceAll("[^a-zA-Z0-9\\s]", ""), n.getId()));
        }
        return result;
    }
}
