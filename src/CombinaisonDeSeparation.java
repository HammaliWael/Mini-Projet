import java.util.*;

public class CombinaisonDeSeparation implements Pretraiteur {

    @Override
    public List<Nom> pretraiter(List<Nom> noms) {
        List<Nom> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();  // Avoid duplicate combinations

        for (Nom n : noms) {
            String[] parts = n.getNom().trim().split("[\\s\\-_]+");
            for (int r = 1; r <= Math.min(parts.length, 3); r++) {
                permute(parts, new boolean[parts.length], new ArrayList<>(), r, result, seen, n.getId());
            }
        }

        return result;
    }

    private static void permute(String[] parts, boolean[] used, List<String> current, int r,
                                List<Nom> result, Set<String> seen, String id) {
        if (current.size() == r) {
            String combined = String.join("", current);
            if (seen.add(combined)) {
                result.add(new Nom(combined, id));
            }
            return;
        }

        for (int i = 0; i < parts.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(parts[i]);
                permute(parts, used, current, r, result, seen, id);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}