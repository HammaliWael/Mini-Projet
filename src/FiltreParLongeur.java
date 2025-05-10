import java.util.ArrayList;
import java.util.List;

public class FiltreParLongeur implements Filtre {
    private int incertitude;

    public int getIncertitude(){ return incertitude; }

    public void setIncertitude(int incertitude) {
        this.incertitude = incertitude;
    }


    public FiltreParLongeur(int incertitude){
        this.incertitude = incertitude;
    }


    public List<Nom> Filtrer(List<Nom> noms, Nom candidat  ) {

        List<Nom> result = new ArrayList<>();
        int length = candidat.getNom().length();
        for(Nom n : noms) {
            if (length-incertitude <= n.getNom().length() && n.getNom().length() <= length + incertitude) {
                result.add(n);
            }
        }
        return result;
    }
}
