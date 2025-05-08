import java.util.Comparator;

public class ExactMatch implements ComparateurDeDeuxNoms , ComparateurDeDeuxStrings {

    public double comparer1(Nom nom1, Nom nom2) {
        if(nom1.getNom().equals(nom2.getNom())) return 1.0;
        return 0.0;
}
    public double comparer2(Nom nom1, Nom nom2) {
        if(nom1.getNom().equals(nom2.getNom())) return 1.0;
        return 0.0;
    }

}
