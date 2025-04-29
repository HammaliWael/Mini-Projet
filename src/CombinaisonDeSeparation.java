import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinaisonDeSeparation implements Pretraiteur {

    public List<Noms> pretraiter(List<Noms> noms) {
        List<Noms> L2 = new ArrayList<>();
        for (Noms n : noms) {
            Set<String> result = new HashSet<>();
            String[] parts = n.getNom().trim().split("\\s+");
            for (int r = 1; r <= parts.length; r++) {
                permute(parts, new boolean[parts.length], new ArrayList<>(), r, result);
            }

            for (String combination : result) {
                L2.add(new Noms(combination, n.getId()));
            }
        }

        return L2;
    }

    private static void permute(String[] parts, boolean[] used, List<String> current, int r, Set<String> result) {
        if (current.size() == r) {
            result.add(String.join("", current));
            return;
        }

        for (int i = 0; i < parts.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(parts[i]);
                permute(parts, used, current, r, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}