import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class FiltreParPartage implements Filtre {
    private int N;

    public FiltreParPartage(int N) {
        this.N = N;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        this.N = n;
    }

    public List<Nom> Filtrer(List<Nom> noms, Nom candidat) {
        List<Nom> result = new ArrayList<>();
        Set<String> S = new HashSet<>(Diviseur(candidat.getNom(), getN()));
        for(Nom n : noms) {
            Set<String> S2 = new HashSet<>(S);
            S2.retainAll(Diviseur(n.getNom(), getN()));
            if (S2.size() == N) {
                result.add(n);
            }
        }
        return result;

    }
    public List<String> Diviseur (String str ,int n) {
            n= getN();
            List<String> result = new ArrayList<>();
            if (str == null || str.length() < n || n <= 0) {
                return result;
            }

            for (int i = 0; i <= str.length() - n; i++) {
                result.add(str.substring(i, i + n));
            }

            return result;
        }
}
