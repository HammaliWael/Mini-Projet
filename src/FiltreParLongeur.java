import java.util.ArrayList;
import java.util.List;

public class FiltreParLongeur implements GenerateurDeCondidats {
    private int incertitude;

    public int getIncertitude(){ return incertitude; }

    public void setIncertitude(int incertitude) {
        this.incertitude = incertitude;
    }


    public FiltreParLongeur(int incertitude){
        this.incertitude = incertitude;
    }


    public List<Noms> generer(List<Noms> noms, Noms candidat  ) {
        List<Noms> result = new ArrayList<>();
        int length = candidat.getNom().length();
        for(Noms n : noms) {
            if (length-incertitude <= n.getNom().length() && n.getNom().length() <= length + incertitude) {
                result.add(n);
            }
        }
        return result;
    }
}
